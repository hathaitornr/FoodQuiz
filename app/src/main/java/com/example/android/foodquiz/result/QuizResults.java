package com.example.android.foodquiz.result;

/**
 * Created by hathaitornr on 1/23/18.
 */

public class QuizResults {

    private int score;

    private boolean[] results;

    public QuizResults(int score, boolean[] results) {
        this.score = score;
        this.results = results;
    }

    public int getScore() {
        return score;
    }

    public boolean[] getResults() {
        return results.clone();
    }

}
