package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.android.foodquiz.result.QuizResults;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.submit:
                QuizResults quizResults = calculateScore();
                submitScore(quizResults);
                break;
        }
    }

    private void submitScore(QuizResults quizResults) {
        Intent resultActivityIntent = new Intent(this, ResultActivity.class);
        resultActivityIntent.putExtra("score", quizResults.getScore());
        resultActivityIntent.putExtra("results", quizResults.getResults());
        this.startActivity(resultActivityIntent);
    }

    private QuizResults calculateScore() {
        int totalScore = 0;

        int[] scores = new int[] {
                getProblem1Score(),
                getProblem2Score(),
                getProblem3Score(),
                getProblem4Score(),
                getProblem5Score(),
                getProblem6Score(),
                getProblem7Score(),
                getProblem8Score(),
                getProblem9Score(),
                getProblem10Score()
        };

        boolean[] results = new boolean[scores.length];

        for (int i = 0; i < scores.length; i++) {
            results[i] = scores[i] != 0;
            totalScore += scores[i];
        }

        return new QuizResults(totalScore, results);
    }

    private int getProblem1Score() {
        int score = 0;

        RadioButton q1AnswerTrue = (RadioButton) findViewById(R.id.q1_answer_true);
        RadioButton q1AnswerFalse = (RadioButton) findViewById(R.id.q1_answer_false);

        if (q1AnswerTrue.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem2Score() {
        int score = 0;

        RadioButton q2AnswerTrue = (RadioButton) findViewById(R.id.q2_answer_true);
        RadioButton q2AnswerFalse = (RadioButton) findViewById(R.id.q2_answer_false);

        if (q2AnswerTrue.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem3Score() {
        int score = 0;

        CheckBox q3Answer1 = (CheckBox) findViewById(R.id.q3_ans1);
        CheckBox q3Answer2 = (CheckBox) findViewById(R.id.q3_ans2);
        CheckBox q3Answer3 = (CheckBox) findViewById(R.id.q3_ans3);
        CheckBox q3Answer4 = (CheckBox) findViewById(R.id.q3_ans4);
        CheckBox q3Answer5 = (CheckBox) findViewById(R.id.q3_ans5);

        if (q3Answer1.isChecked() && q3Answer2.isChecked() && q3Answer3.isChecked()
                && !q3Answer4.isChecked() && q3Answer5.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem4Score() {
        int score = 0;

        RadioButton q4Check1 = (RadioButton) findViewById(R.id.q4_check1);
        RadioButton q4Check2 = (RadioButton) findViewById(R.id.q4_check2);
        RadioButton q4Check3 = (RadioButton) findViewById(R.id.q4_check3);

        if (q4Check2.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem5Score() {
        int score = 0;

        RadioButton q5Check1 = (RadioButton) findViewById(R.id.q5_check1);
        RadioButton q5Check2 = (RadioButton) findViewById(R.id.q5_check2);
        RadioButton q5Check3 = (RadioButton) findViewById(R.id.q5_check3);

        if (q5Check1.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem6Score() {
        int score = 0;

        EditText q6Answer = (EditText) findViewById(R.id.q6_edit_text);
        String answer = q6Answer.getText().toString();

        if (answer.equals("2")) {
            score += 10;
        }

        return score;
    }

    private int getProblem7Score() {
        int score = 0;

        RadioButton q7AnswerTrue = (RadioButton) findViewById(R.id.q7_answer_true);
        RadioButton q7AnswerFalse = (RadioButton) findViewById(R.id.q7_answer_false);

        if (q7AnswerTrue.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem8Score() {
        int score = 0;

        RadioButton q8Check1 = (RadioButton) findViewById(R.id.q8_check1);
        RadioButton q8Check2 = (RadioButton) findViewById(R.id.q8_check2);

        if (q8Check2.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem9Score() {
        int score = 0;

        RadioButton q9AnswerTrue = (RadioButton) findViewById(R.id.q9_answer_true);
        RadioButton q9AnswerFalse = (RadioButton) findViewById(R.id.q9_answer_false);

        if (q9AnswerTrue.isChecked()) {
            score += 10;
        }

        return score;
    }

    private int getProblem10Score() {
        int score = 0;

        RadioButton q10Check1 = (RadioButton) findViewById(R.id.q10_check1);
        RadioButton q10Check2 = (RadioButton) findViewById(R.id.q10_check2);

        if (q10Check2.isChecked()) {
            score += 10;
        }

        return score;
    }
}
