package com.example.new_vocabulary.Model;

import java.util.Collections;
import java.util.List;

// Created by DANIEL DIAZ on 5/15/2020.
public class QuestionBank {
    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList = questionList;
        //Shuffle the question list
        Collections.shuffle(mQuestionList);
        mNextQuestionIndex=0;
    }

    public Question getQuestion() {
        //Ensure we loop over the questions
        if (mNextQuestionIndex == mQuestionList.size()){
            mNextQuestionIndex =0;
        }
        return mQuestionList.get(mNextQuestionIndex++);
    }
}