package com.herosofnewerth.my;


import android.app.Activity;
import android.widget.TextView;

public class Score {
    private Activity actv;

    private int guessesLeft = 3;
    private int points = 0;

    private TextView score;
    private TextView guesses;

    public Score(Activity actv, int guessesLeft) {
        this.actv = actv;
        this.guessesLeft = guessesLeft;
    }

    public void addPoint() {
        points++;
        score.setText(Integer.toString(points));
    }

    public void subGuesses() {
        guessesLeft--;
        guesses.setText(Integer.toString(guessesLeft));
    }

    public int getPoints() {
        return points;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public void prepareScore() {
        score = (TextView)actv.findViewById(R.id.score);
        score.setText(Integer.toString(points));

        guesses = (TextView)actv.findViewById(R.id.guessesLeft);
        guesses.setText(Integer.toString(guessesLeft));
    }
}
