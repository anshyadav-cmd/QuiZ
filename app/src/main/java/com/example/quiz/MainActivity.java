package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int progress = 10;
    private Button trueBtn;
    private Button falseBtn;
    private TextView questionTextView;
    private TextView statsTextView;
    private ProgressBar quizPB;

    private int questionIndex = 0;

    private QuizModel[] questionsCollections = new QuizModel[]
    {
        new QuizModel(R.string.que1, true),
        new QuizModel(R.string.que2, false),
        new QuizModel(R.string.que3, false),
        new QuizModel(R.string.que4, false),
        new QuizModel(R.string.que5, true),
        new QuizModel(R.string.que6, true),
        new QuizModel(R.string.que7, false),
        new QuizModel(R.string.que8, false),
        new QuizModel(R.string.que9, false),
        new QuizModel(R.string.que10, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueBtn = findViewById(R.id.trueButton);
        falseBtn = findViewById(R.id.falseButton);
        questionTextView = findViewById(R.id.questionTextView);
        statsTextView = findViewById(R.id.quizStatsTextView);
        quizPB = findViewById(R.id.quizPB);

        questionTextView.setText(questionsCollections[questionIndex].getmQuestion());

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionsCollections[questionIndex].ismAnswer()){
                    trueBtn.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                }else {
                    trueBtn.setBackgroundColor(getResources().getColor(R.color.worngAnswer));
                }
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!questionsCollections[questionIndex].ismAnswer()){
                    falseBtn.setBackgroundColor(getResources().getColor(R.color.correctAnswer));
                }else {
                    falseBtn.setBackgroundColor(getResources().getColor(R.color.worngAnswer));
                }
            }
        });
    }
    public void changeQuestion(View buttonView) {
        questionIndex = (questionIndex+1) % 10;
        quizPB.incrementProgressBy(progress);
        questionTextView.setText(questionsCollections[questionIndex].getmQuestion());
        resetButtons();
    }
    private void resetButtons(){
        trueBtn.setBackgroundColor(getResources().getColor(R.color.purple_500));
        falseBtn.setBackgroundColor(getResources().getColor(R.color.purple_500));
    }

}
