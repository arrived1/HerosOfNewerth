package com.herosofnewerth.my;

import android.app.Activity;
import android.widget.Chronometer;

public class Timer {
    private Chronometer mChronometer;

    public Timer(Activity actv) {
        mChronometer = (Chronometer)actv.findViewById(R.id.time);
        mChronometer.start();
    }

    public void stopTimer() {
        mChronometer.stop();
    }

    public CharSequence getTimeTxt() {
        return mChronometer.getText();
    }
}
