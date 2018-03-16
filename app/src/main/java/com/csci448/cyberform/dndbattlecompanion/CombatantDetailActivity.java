package com.csci448.cyberform.dndbattlecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Dylan on 2/28/2018.
 */

public class CombatantDetailActivity extends AppCompatActivity {

    Button mAttacksButton;
    Button mAbilitiesButton;
    Button mSkillsButton;
    Button mStatusesButton;
    ImageButton mCameraButton;
    LinearLayout mStatBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combatant_detail);


        //Buttons launch new activities
        mAttacksButton = findViewById(R.id.attacks_button);
        mAttacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CombatantDetailActivity.this, AttackScrollActivity.class);
                startActivity(intent);
            }
        });

        mAbilitiesButton = findViewById(R.id.abilities_button);
        mAbilitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CombatantDetailActivity.this, AbilitiesActivity.class);
                startActivity(intent);
            }
        });

        mSkillsButton = findViewById(R.id.skills_button);
        mSkillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CombatantDetailActivity.this, SkillsActivity.class);
                startActivity(intent);
            }
        });

        //Temporary toasts to explain future functionality in alpha release
        mStatusesButton = findViewById(R.id.statuses_button);
        mStatusesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CombatantDetailActivity.this, "User can click status icons to apply/remove. First two will appear in combatant quick view.", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(CombatantDetailActivity.this, StatusesActivity.class);
                startActivity(intent);
            }
        });

        mStatBar = findViewById(R.id.stat_bar);
        mStatBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CombatantDetailActivity.this, "Displays and allows user to modify base save modifiers", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        mCameraButton = findViewById(R.id.camera_button);
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(CombatantDetailActivity.this, "Opens camera activity. Allows user to take a picture or display a picture taken.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
