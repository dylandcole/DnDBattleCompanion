package com.csci448.cyberform.dndbattlecompanion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by dwdco on 3/15/2018.
 */

public class SkillsActivity extends AppCompatActivity {

    LinearLayout mStatBar;
    LinearLayout mSkillBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        mStatBar = findViewById(R.id.stat_bar);
        mStatBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(SkillsActivity.this, "Displays and allows user to modify base stat modifiers", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        mSkillBlock = findViewById(R.id.skill_block);
        mSkillBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(SkillsActivity.this, "Calculates skill modifiers from stat modifiers and proficiency. " +
                        "Click skill to set proficiency", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
