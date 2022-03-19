package com.example.quiz;

public class QuizModel {
    private final int mQuestion;
    private final boolean mAnswer ;

    public QuizModel(int mQuestion, boolean mAnswer) {
        this.mQuestion = mQuestion;
        this.mAnswer = mAnswer;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }
}
