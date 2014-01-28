package com.herosofnewerth.my;

import android.app.ListActivity;
import android.os.Bundle;


public class TabActivityHeroDeathMatch extends ListActivity {

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        DatabaseHandler db = new DatabaseHandler(this, TABLE.HeroDeathMetch);

        ListAdapter adapter = new ListAdapter(this, db.getAllRecords());
        setListAdapter(adapter);
    }
}
