package com.herosofnewerth.my;

import android.app.Activity;
import android.media.MediaPlayer;

import java.util.Random;

public class GameSounds {
    private Activity actv;

    private void playSound(int id) {
        MediaPlayer mp = null;
        try {
            mp = MediaPlayer.create(actv, id);
            mp.start();
        }
        catch(Exception e) {
            if(!mp.equals(null))
                mp.release();
        }
    }

    public GameSounds(Activity actv_) {
        this.actv = actv_;
    }

    public void welcome() {
        playSound(R.raw.welcome);
    }

    public void playMusic() {
        playSound(R.raw.ab1_vox_1);
    }

    public void correct() {
        playSound(R.raw.correct);
    }

    public void incorrect() {
        playSound(R.raw.incorrect);
    }

    public void gameOver() {
        Random rand = new Random();
        Integer sound = rand.nextInt(1) + 1;

        if(sound.equals(0))
            playSound(R.raw.game_over);
        else
            playSound(R.raw.yum);
    }

    public void correctNumber(int num) {
        switch (num) {
            case 1:
                playSound(R.raw.first_blood);
                break;
            case 3:
                playSound(R.raw.kills3);
                break;
            case 6:
                playSound(R.raw.kills4);
                break;
            case 12:
                playSound(R.raw.kills5);
                break;
            case 24:
                playSound(R.raw.kills6);
                break;
            case 40:
                playSound(R.raw.kills7);
                break;
            case 80:
                playSound(R.raw.kills8);
                break;
            case 120:
                playSound(R.raw.kills9);
                break;
            case 170:
                playSound(R.raw.kills10);
                break;
            case 210:
                playSound(R.raw.cartoon_jump);
                break;
            case 250:
                playSound(R.raw.cartoon_jump);
                break;
            case 300:
                playSound(R.raw.cartoon_jump);
                break;
            default:
                break;
        }
    }
}
