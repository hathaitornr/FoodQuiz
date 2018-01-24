package com.example.android.foodquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.foodquiz.result.QuizResults;

public class ResultActivity extends AppCompatActivity {

    private TextView scoreDisplay;

    private TextView[] resultDisplays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        findViews();

        QuizResults quizResults = getQuizResultsFromPreviousActivity();
        populateQuizResults(quizResults);
    }

    private void findViews() {
        scoreDisplay = (TextView) findViewById(R.id.score);

        resultDisplays = new TextView[] {
                (TextView) findViewById(R.id.q1_ans),
                (TextView) findViewById(R.id.q2_ans),
                (TextView) findViewById(R.id.q3_ans),
                (TextView) findViewById(R.id.q4_ans),
                (TextView) findViewById(R.id.q5_ans),
                (TextView) findViewById(R.id.q6_ans),
                (TextView) findViewById(R.id.q7_ans),
                (TextView) findViewById(R.id.q8_ans),
                (TextView) findViewById(R.id.q9_ans),
                (TextView) findViewById(R.id.q10_ans)
        };
    }

    private QuizResults getQuizResultsFromPreviousActivity() {
        int score = getIntent().getIntExtra("score", 0);
        boolean[] results = getIntent().getBooleanArrayExtra("results");
        return new QuizResults(score, results);
    }

    private void populateQuizResults(QuizResults quizResults) {
        scoreDisplay.setText(String.valueOf(quizResults.getScore()));

        boolean[] results = quizResults.getResults();

        for (int i = 0; i < resultDisplays.length; i++) {
            int resultResId = (results[i]) ? R.string.correct : R.string.incorrect;
            resultDisplays[i].setText(resultResId);
        }
    }

}
