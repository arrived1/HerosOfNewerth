package com.herosofnewerth.my;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class ButtonOnClickListenerScoreBoard implements View.OnClickListener {
    private Activity actv;

    public ButtonOnClickListenerScoreBoard(Activity activity_) {
        this.actv = activity_;
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(actv, ScoreBoardActivity.class);
        actv.startActivity(myIntent);
    }
}
