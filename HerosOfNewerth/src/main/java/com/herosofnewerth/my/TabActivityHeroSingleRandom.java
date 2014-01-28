package com.herosofnewerth.my;

import android.app.ListActivity;
import android.os.Bundle;


public class TabActivityHeroSingleRandom extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        DatabaseHandler db = new DatabaseHandler(this, TABLE.HeroSingleRandom);
        db.cleanup();

        ListAdapter adapter = new ListAdapter(this, db.getAllRecords());
        setListAdapter(adapter);
    }
}
