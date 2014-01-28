package com.herosofnewerth.my;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by SG0220055 on 1/23/14.
 */
public class Animations {
    private Animation animFadein;
    private Animation leftRight;
    private Animation rightLeft;
    private Animation downTop;
    private Animation topDown;

    public Animations(Context context) {
        animFadein = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.fade_in);
        leftRight = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.left_right);
        rightLeft = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.right_left);
        downTop = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.down_top);
        topDown = AnimationUtils.loadAnimation(context.getApplicationContext(), R.anim.top_down);
    }

    public Animation getAnimFadein() {
        return animFadein;
    }

    public Animation getRightLeft() {
        return rightLeft;
    }

    public Animation getLeftRight() {
        return leftRight;
    }

    public Animation getDownTop() {
        return downTop;
    }

    public Animation getTopDown() {
        return topDown;
    }
}
