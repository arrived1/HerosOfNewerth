package com.herosofnewerth.my;

import android.app.ListActivity;
import android.os.Bundle;


public class TabActivitySkillSingleRandom extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        DatabaseHandler db = new DatabaseHandler(this, TABLE.SkillSingleRandom);
        db.cleanup();

        ListAdapter adapter = new ListAdapter(this, db.getAllRecords());
        setListAdapter(adapter);
    }
}
