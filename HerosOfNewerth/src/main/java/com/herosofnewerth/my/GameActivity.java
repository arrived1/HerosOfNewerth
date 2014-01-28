package com.herosofnewerth.my;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GameActivity extends Activity {
    private Animations animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameSounds sounds = new GameSounds(this);
        sounds.welcome();

        animation  = new Animations(this);

        addListenerOnButtonSkillQuiz();
        addListenerOnButtonHeroQuiz();
        addListenerOnButtonScoreBoard();

        ImageView imageView = (ImageView)findViewById(R.id.logo);
        imageView.startAnimation(animation.getAnimFadein());
    }

    private void addListenerOnButtonSkillQuiz() {
        final Button button = (Button)findViewById(R.id.skillQuiz);
        button.setAnimation(animation.getLeftRight());
        button.setOnClickListener(new ButtonOnClickListenerSkillGameModePicker(this));
    }

    private void addListenerOnButtonHeroQuiz() {
        final Button button = (Button)findViewById(R.id.heroQuiz);
        button.setAnimation(animation.getRightLeft());
        button.setOnClickListener(new ButtonOnClickListenerHeroGameModePicker(this));
    }

    private void addListenerOnButtonScoreBoard() {
        final Button button = (Button)findViewById(R.id.scoreBoard);
        button.setAnimation(animation.getDownTop());
        button.setOnClickListener(new ButtonOnClickListenerScoreBoard(this));
    }
}
