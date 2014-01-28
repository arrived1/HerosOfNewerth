package com.herosofnewerth.my;

import android.app.ListActivity;
import android.os.Bundle;


public class TabActivitySkillDeathMatch extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        DatabaseHandler db = new DatabaseHandler(this, TABLE.SkillDeathMetch);

        ListAdapter adapter = new ListAdapter(this, db.getAllRecords());
        setListAdapter(adapter);
    }
}
