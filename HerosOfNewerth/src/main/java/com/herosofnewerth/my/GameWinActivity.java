package com.herosofnewerth.my;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class GameWinActivity extends Activity {
    private Animations animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);

        GameSounds sounds = new GameSounds(this);
        sounds.gameOver();

        Bundle extras = getIntent().getExtras();
        int points = extras.getInt("SCORE");
        String timeTxt = extras.getString("TIME");

        ImageView gameOverImage = (ImageView)findViewById(R.id.logo);
        gameOverImage.setImageResource(R.drawable.small_logo);

        TextView score = (TextView)findViewById(R.id.scoreRes);
        score.setText(Integer.toString(points));

        TextView time = (TextView)findViewById(R.id.timeRes);
        time.setText(timeTxt);

        animation = new Animations(this);

        ImageView imageView = (ImageView)findViewById(R.id.logo);
        imageView.startAnimation(animation.getAnimFadein());
    }
}
