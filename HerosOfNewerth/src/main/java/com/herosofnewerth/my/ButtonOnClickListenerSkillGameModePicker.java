package com.herosofnewerth.my;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class ButtonOnClickListenerSkillGameModePicker implements View.OnClickListener {
    private Activity actv;

    public ButtonOnClickListenerSkillGameModePicker(Activity activity_) {
        this.actv = activity_;
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent(actv, SkillGameModelPickerActivity.class);
        actv.startActivity(myIntent);
    }
}
