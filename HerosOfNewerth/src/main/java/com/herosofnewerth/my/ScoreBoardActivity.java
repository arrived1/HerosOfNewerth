package com.herosofnewerth.my;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("ALL")
public class ScoreBoardActivity extends android.app.TabActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        // create the TabHost that will contain the Tabs
        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("Third Tab");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("Forth Tab");


        // Set the Tab name and Activity
        // that will be opened when particular Tab will be selected
        tab1.setIndicator("Skill Single Random");
        tab1.setContent(new Intent(this, TabActivitySkillSingleRandom.class));

        tab2.setIndicator("Skill Death Match");
        tab2.setContent(new Intent(this, TabActivitySkillDeathMatch.class));

        tab3.setIndicator("Hero Single Random");
        tab3.setContent(new Intent(this, TabActivityHeroSingleRandom.class));

        tab4.setIndicator("Hero Death Match");
        tab4.setContent(new Intent(this, TabActivityHeroDeathMatch.class));


        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);
    }
}

