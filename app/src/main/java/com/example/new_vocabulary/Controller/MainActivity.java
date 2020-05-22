package com.example.new_vocabulary.Controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.new_vocabulary.Model.User;
import com.example.new_vocabulary.R;

public class MainActivity extends AppCompatActivity {

    public static final int GAME_ACTIVITY_REQUEST_CODE=42;
    public static final String PREF_KEY_NAME = "PREFERENCE KEY NAME";
    public static final String PREF_KEY_SCORE = "PREFERENCE KEY SCORE";

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //Linking Variables:
        mGreetingText=findViewById(R.id.activity_main_greeting_txt);
        mNameInput=findViewById(R.id.activity_main_name_input);
        mPlayButton=findViewById(R.id.activity_main_play_btn);
        mUser=new User();
        mPreferences=getPreferences(MODE_PRIVATE);
        //Enable the play button once the user start typing a name:
        mPlayButton.setEnabled(false);
//        System.out.println("Before greetUser");
        greetUser();

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
     //Launching a new activity after clicking the play button:

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setFirstName(mNameInput.getText().toString());
                mPreferences.edit().putString(PREF_KEY_NAME,mUser.getFirstName()).apply();
                //Launching a new activity:
                Intent newVocabularyActivity = new Intent(MainActivity.this, New_Vocabulary.class);
                startActivityForResult(newVocabularyActivity,GAME_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        System.out.println("segunda vez");
        if (requestCode == GAME_ACTIVITY_REQUEST_CODE && resultCode==RESULT_OK){
            int score = data.getIntExtra(New_Vocabulary.BUNDLE_EXTRA_SCORE,0);
            mPreferences.edit().putInt(PREF_KEY_SCORE,score).apply();
            greetUser();
 //           System.out.println("Segunda vez interno"+score);
        }
    }

    private void greetUser() {
        String firstname = mPreferences.getString(PREF_KEY_NAME,null);
//        System.out.println(firstname);
        if (null != firstname){
//            System.out.println("if" +firstname);
            int score = mPreferences.getInt(PREF_KEY_SCORE,0);
            String fulltext = "Welcome back, " +firstname+ "\nYour last score was: "+score+"/10, will you do better this time?";
            mGreetingText.setText(fulltext);
            mNameInput.setText(firstname);
            mPlayButton.setEnabled(true);
        }
    }
}
