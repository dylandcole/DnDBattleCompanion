package com.csci448.cyberform.dndbattlecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by dwdco on 3/15/2018.
 */

public class StatusesActivity extends AppCompatActivity {
    LinearLayout mStatusBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statuses);

        mStatusBlock = findViewById(R.id.status_activity_layout);
        mStatusBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(StatusesActivity.this, "User can click status icons to apply/remove. First two will appear in combatant quick view.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
