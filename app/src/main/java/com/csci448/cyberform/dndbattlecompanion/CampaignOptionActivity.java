package com.csci448.cyberform.dndbattlecompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by dwdco on 2/28/2018.
 */

public class CampaignOptionActivity extends AppCompatActivity {

    private Button mCharactersButton;
    private Button mBattlesButton;
    private Button mGeneralEnemiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_options);

        mCharactersButton = findViewById(R.id.characters_button);
        mCharactersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampaignOptionActivity.this, CombatantScrollActivity.class);
                startActivity(intent);
            }
        });

        mBattlesButton = findViewById(R.id.battles_button);
        mBattlesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampaignOptionActivity.this, BattleScrollActivity.class);
                startActivity(intent);
            }
        });

        mGeneralEnemiesButton = findViewById(R.id.general_enemies_button);
        mGeneralEnemiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CampaignOptionActivity.this, CombatantScrollActivity.class);
                startActivity(intent);
            }
        });
        setTitle("Campaign Options");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_campaign_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.create_notification:
                Toast toast = Toast.makeText(this, "Opens popup for the user to set a weekly preparation reminder", Toast.LENGTH_LONG);
                toast.show();
            default:

        }
        return true;
    }
}
