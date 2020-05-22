package com.example.new_vocabulary.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.new_vocabulary.Model.Question;
import com.example.new_vocabulary.Model.QuestionBank;
import com.example.new_vocabulary.R;

import java.util.Arrays;

public class New_Vocabulary extends AppCompatActivity implements View.OnClickListener {
    public static final String BUNDLE_EXTRA_SCORE="BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE="BUNDLE_STATE_SCORE";

    private TextView mQuestiontxt;
    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;

    private Question mCurrentQuestion;
    private QuestionBank mQuestionBank;
    private int mScore;
    private int mNumQuestions;
    private boolean mEnableTouchEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__vocabulary);

        // Linking Variables:
        mQuestiontxt=findViewById(R.id.new_vocabulary_question_txt);
        mAnswer1=findViewById(R.id.new_vocabulary_answer1);
        mAnswer2=findViewById(R.id.new_vocabulary_answer2);
        mAnswer3=findViewById(R.id.new_vocabulary_answer3);
        mAnswer4=findViewById(R.id.new_vocabulary_answer4);

        mAnswer1.setOnClickListener(this);
        mAnswer2.setOnClickListener(this);
        mAnswer3.setOnClickListener(this);
        mAnswer4.setOnClickListener(this);

        //Use the tag property to name the buttons:
        mAnswer1.setTag(0);
        mAnswer2.setTag(1);
        mAnswer3.setTag(2);
        mAnswer4.setTag(3);

        mNumQuestions=10;

        mEnableTouchEvents=true;

        mQuestionBank=this.generateQuestions();

        System.out.println("Banco de preguntas: "+Arrays.asList(mQuestionBank));

        mCurrentQuestion=mQuestionBank.getQuestion();

        System.out.println("Pregunta actual: "+mCurrentQuestion);

        this.displayQuestion(mCurrentQuestion);


      //  System.out.println(mCurrentQuestion.getQuestion());

    }

    private QuestionBank generateQuestions (){

        Question question1 = new Question("Custom officers XXX those who don't have a passport.",
                Arrays.asList("turned away","deceived","undermined","staggered"),0);

        Question question2 = new Question("The buyer XXX his payments over three months.",
                Arrays.asList("evicted","deceived","issued","staggered"),3);

        Question question3 = new Question("A XXX amount of money.",
                Arrays.asList("pulling off","flattening","scaffolding","staggering"),3);

        Question question4 = new Question("No one can't be XXX for non payment of rent",
                Arrays.asList("bailed out","evicted","put off","sugar coated"),1);

        Question question5 = new Question("Rather than this hospital has to XXX, another hospital can help it",
                Arrays.asList("run away","prompt","come out","scramble"),3);

        Question question6 = new Question("He will do the best efforts to XXX salaries to 100%",
                Arrays.asList("top up","gain","issued","curse"),0);

        Question question7 = new Question("My XXX is really busy this week",
                Arrays.asList("work load","top up","sprain","cope"),0);

        Question question8 = new Question("Everything you need to know about XXX e-mails",
                Arrays.asList("toss out","sketchy","undermined","staggered"),1);

        Question question9 = new Question("My mother XXX some money for emergencies.",
                Arrays.asList("overlooked","played","set aside","coped"),2);

        Question question10 = new Question("We will XXX by leaning on each other.",
                Arrays.asList("fall","get through","run away","walk into"),1);

        Question question11 = new Question("Lee realizes she XXX when she didn't see her money into her bank account",
                Arrays.asList("fall for a scam","turn upside down","eased","turn away"),0);

        Question question12= new Question("An ankle XXX is an injury to the ligaments in the ankle",
                Arrays.asList("bruise","sprain","spread","accident"),1);

        Question question13 = new Question("The patient has XXX on her legs due to a fall",
                Arrays.asList("bruises","problems","needles","scrambles"),0);

        Question question14 = new Question("The burglar XXX the alarm",
                Arrays.asList("played","pushed","tripped","pulled"),2);

        Question question15 = new Question("I almost XXX on the uneven steps",
                Arrays.asList("set aside","top up","tripped","coped"),2);

        Question question16 = new Question("The group suggests substituting the XXX with pallet jacks",
                Arrays.asList("ladder","forklift","jack","bullet"),1);

        Question question17 = new Question("The XXX typically has to sense when a work piece is about to pass",
                Arrays.asList("photo eye","capacitor","LED","motor"),0);

        Question question18 = new Question("The university XXX student identification cards before starting the scholar year",
                Arrays.asList("keeps up","issues","tosses out","walks into"),1);

        Question question19 = new Question("Be careful!, a brick could falls from that XXX",
                Arrays.asList("pipe","river","robot","scaffold"),3);

        Question question20= new Question("We must concentrate and don't XXX any details",
                Arrays.asList("realize","overlook","jump","think"),1);

        Question question21 = new Question("That doesn't mean you can XXX of the preventive measures",
                Arrays.asList("stop","continue","back off","play"),2);

        Question question22 = new Question("The users expect a XXX response from the company",
                Arrays.asList("wrong","late","delay","prompt"),3);

        Question question23 = new Question("The teacher XXX the shy student to talk",
                Arrays.asList("prompted","did","kept","coped"),0);

        Question question24 = new Question("Phone calls are coming in a rate that I'm not able to XXX",
                Arrays.asList("attend","keep up","tossed out","suggest"),1);

        Question question25 = new Question("All workplaces need a monthly inspection XXX the number of employees.",
                Arrays.asList("regardless of","within","but","over"),0);

        Question question26 = new Question("XXX with the impact of the economic crisis.",
                Arrays.asList("Treating","Having","Coping","Staggering"),2);

        Question question27 = new Question("I visited my grandmother in the XXX yesterday.",
                Arrays.asList("university","school","old house","nursing home"),3);

        Question question28 = new Question("The curse is starting to XXX in BC",
                Arrays.asList("play","bend","need","roll"),1);

        Question question29 = new Question("You continue to XXX the curve",
                Arrays.asList("have","best","flattening","scramble"),2);

        Question question30 = new Question("Life was going so well, but all of a sudden seems as if it has been XXX",
                Arrays.asList("turned upside down","coping","need","curse"),0);

        Question question31 = new Question("The painting is XXX on the wall by mistake",
                Arrays.asList("new","laid","position","upside down"),3);

        Question question32 = new Question("My friend XXX to be a great singer",
                Arrays.asList("aims","like","need","dream"),0);

        Question question33 = new Question("The medicine XXX the pain caused by the inflammation.",
                Arrays.asList("free","hurts","eases","reset"),2);

        Question question34 = new Question("Companies had to XXX their operations.",
                Arrays.asList("fall","get through","run away","scale back"),3);

        Question question35 = new Question("It's too early to XXX covid-19 measures.",
                Arrays.asList("fall for a scam","turn upside down","scale back","turn away"),2);

        Question question36= new Question("I pulled at the drawer, and the handle XXX.",
                Arrays.asList("damaged","came off","spread","accident"),1);

        Question question37 = new Question("These trials are done daily to see if the person is ready to XXX the ventilator.",
                Arrays.asList("scale","need","quit","come off"),3);

        Question question38 = new Question("The sun XX between the clouds.",
                Arrays.asList("undermine","came out","have","pulled"),1);

        Question question39 = new Question("He is a bit of a XXX for my liking",
                Arrays.asList("accident","needless","good","cocky"),3);

        Question question40 = new Question("It's XXX what they are capable of after only a verbal briefing.",
                Arrays.asList("aiming","having","logical","mind-boggling"),3);

        Question question41 = new Question("They are offering to XXX the commercial banks.",
                Arrays.asList("pull","scale","recover","bail out"),3);

        Question question42 = new Question("Don't XXX or try to refill ink cartridges.",
                Arrays.asList("build","charge","take apart","quit"),2);

        Question question43 = new Question("Nobody that needs a ventilator has been XXX.",
                Arrays.asList("needed","took","accepted","turned down"),3);

        Question question44= new Question("Both parties wanted to XXX the problem.",
                Arrays.asList("realizes","sort out","jump","think"),1);

        Question question45 = new Question("This situation came XXX",
                Arrays.asList("stop","bad","out of the blue","play"),2);

        Question question46 = new Question("They XXX him XXX of the bar after he started a fight.",
                Arrays.asList("set up","hurry up","run away","tossed out"),3);

        Question question47 = new Question("He has been upgraded to XXX",
                Arrays.asList("fair condition","be better ","a level","up scale"),0);

        Question question48 = new Question("The coach XXX me XXX when he saw that I was in pain.",
                Arrays.asList("pull over","pulled off","take over","suggest out"),1);

        Question question49 = new Question("He wants to XXX all of the possibilities before deciding what to do.",
                Arrays.asList("scope out","analyze","make up","mind-bogging"),0);

        Question question50 = new Question("Yesterday, I XXX work early to pick up my son.",
                Arrays.asList("stop","scale","get out","bail out"),2);

        Question question51 = new Question("I will XXX the train at the next station.",
                Arrays.asList("build up","charge","stop","get off"),3);

        Question question52 = new Question("My friend should face reality and not XXX himself.",
                Arrays.asList("needed","dissapoint","play","deceive"),3);

        Question question53= new Question("Finally, many fisherman think that learning to swim is a bad XXX.",
                Arrays.asList("reality","omen","jump","behaviour"),1);

        Question question54 = new Question("This note is just to give you a XXX that Vicky will be arriving next week.",
                Arrays.asList("sentence","notice","new","heads-up"),3);

        Question question55 = new Question("XXX, it usually takes years before they show their effect.",
                Arrays.asList("then","on top of that","after a while","as soon as possible"),1);

        Question question56 = new Question("I have a Jeep XXX on the other side.",
                Arrays.asList("close","needed ","driving","standing by"),3);

        Question question57 = new Question("I thank you to those of you working from home or on XXX to work.",
                Arrays.asList("call","stand by","take over","suggest out"),1);

        Question question58= new Question("My brother loves to XXX me when I'm studying",
                Arrays.asList("realize","overlook","fuss","think"),2);

        Question question59 = new Question("She tried to XXX my authority by complaining about me to my boss.",
                Arrays.asList("stop","continue","undermine","overcome"),2);

        Question question60 = new Question("He XXX me XXX to look like a rat.",
                Arrays.asList("hang up","take off","put on","set up"),3);

        Question question61 = new Question("The valet XXX our car XXX, and we all got in.",
                Arrays.asList("pull around","take off","set up","put over"),0);

        Question question62 = new Question("Today is not a day to XXX",
                Arrays.asList("attend","fall apart","tossed out","suggest"),1);

        Question question63 = new Question("After just one drink, I was XXX.",
                Arrays.asList("buzzed","overload","out","over"),0);

        Question question64 = new Question("Usually a man can start to feel XXX after consuming 2 to 3 alcoholic drinks in an hour.",
                Arrays.asList("undermine","overcome","tipsy","Staggering"),2);

        Question question65 = new Question("Some people think the old house is XXX.",
                Arrays.asList("needed","scaled","overwhelming","cursed"),3);

        Question question66 = new Question("I'll go XXX them",
                Arrays.asList("check over","check on","check in","check out"),1);

        Question question67 = new Question("The player had XXX the game and he always won.",
                Arrays.asList("had","checked","rigged","play"),2);

        Question question68 = new Question("I had to XXX the invitation because I was too busy",
                Arrays.asList("turn down","accept","ask","curse"),0);

        Question question69 = new Question("We had to XXX our excursion because of the rain.",
                Arrays.asList("attend","put off","tossed out","clear"),1);

        Question question70 = new Question("After just one drink, I was XXX.",
                Arrays.asList("buzzed","overload","out","over"),0);

        Question question71 = new Question("I don' want to XXX the situation.",
                Arrays.asList("undermine","turn down","sugar coat","enjoy"),2);

        Question question72 = new Question("The flight was an XXX because I had no leg room.",
                Arrays.asList("needed","scaled","overwhelming","ordure"),3);

        Question question73 = new Question("The car XXX due to a defective traffic light",
                Arrays.asList("hit","crashed","broke over","check out"),1);

        Question question74 = new Question("People who need to XXX a ventilator.",
                Arrays.asList("installed","synchronize","put on","attend"),2);

        Question question75 = new Question("I always XXX sunscreen XXX when I go to the beach.",
                Arrays.asList("put on","accept","take out","take in"),0);

        Question question76 = new Question("I XXX 30 euros XXX the fastest horse.",
                Arrays.asList("drive in","throw away","put on","pick up"),2);

        Question question77 = new Question("The teachers went on XXX to protest budget cuts.",
                Arrays.asList("strike","accept","protest","bankruptcy"),0);

        return new QuestionBank(Arrays.asList(question1,question2,question3,question4,question5,
                question6,question7,question8,question9,question10,question11,question11,question12,
                question13,question14,question15,question16,question17,question18,question19,
                question20,question21,question22,question23,question24,question25,question26,
                question27,question28,question29,question30,question31,question32,question33,question34,
                question35,question36,question37,question38,question39,question40,question41,question42,
                question43,question44,question45,question46,question47,question48,question49,question50,
                question51,question52,question53,question54,question55,question56,question57,question58,
                question59,question60,question61,question62,question63,question64,question65,question66,
                question67,question68,question69,question70,question71,question72,question73,question74,
                question75,question76,question77));
    }
    private void displayQuestion (Question currentQuestion){
        mQuestiontxt.setText(currentQuestion.getQuestion());
        mAnswer1.setText(currentQuestion.getChoiceList().get(0));
        mAnswer2.setText(currentQuestion.getChoiceList().get(1));
        mAnswer3.setText(currentQuestion.getChoiceList().get(2));
        mAnswer4.setText(currentQuestion.getChoiceList().get(3));
        System.out.println("mostrando");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View v) {
        int userAnswer = (int) v.getTag();
        if (userAnswer==mCurrentQuestion.getAnswerIndex()){
            Toast.makeText(New_Vocabulary.this,"Good job!",Toast.LENGTH_SHORT).show();
            mScore++;
        }
        else {
            Toast.makeText(New_Vocabulary.this,"uh oh, that's wrong!",Toast.LENGTH_SHORT).show();
        }
        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
 //               System.out.println("Running delay");
                if (--mNumQuestions==0){
                    endGame();
                }
                else {
                    mCurrentQuestion=mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
                mEnableTouchEvents=true;
            }
        },2000);

    }

    private void endGame() {
        new AlertDialog.Builder(this).setTitle("Well Done")
                .setMessage("Your score is: "+mScore+"/10")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent data = new Intent();
 //                       int totalScore = (mScore/mNumQuestions)*100;
                       data.putExtra(BUNDLE_EXTRA_SCORE,mScore);
                       setResult(RESULT_OK,data);
 //                      System.out.println(mScore);
                        //Close the activity:
                        finish();
                    }
                }).create().show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE,mScore);
        super.onSaveInstanceState(outState);
    }
}