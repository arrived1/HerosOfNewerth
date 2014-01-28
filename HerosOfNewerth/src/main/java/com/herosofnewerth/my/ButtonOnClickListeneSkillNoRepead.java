package com.herosofnewerth.my;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class ButtonOnClickListeneSkillNoRepead implements View.OnClickListener {
    private Activity actv;
    private int chances;

    public ButtonOnClickListeneSkillNoRepead(Activity activity_, int chances) {
        this.actv = activity_;
        this.chances = chances;
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(actv, SkillQuizActivityNorRepead.class);
        myIntent.putExtra("CHANCES", chances);
        actv.startActivity(myIntent);
    }
}
