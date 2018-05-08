package com.csci448.cyberform.dndbattlecompanion;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dwdco on 2/28/2018.
 */

public class CampaignOptionActivity extends AppCompatActivity {

    private Button mCharactersButton;
    private Button mBattlesButton;
    private Button mGeneralEnemiesButton;

    public static Intent newIntent(Context context) {
        return new Intent(context, CampaignOptionActivity.class);
    }

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
                final Calendar tempCalendar = Calendar.getInstance();
                DatePickerDialog notificationDate = new DatePickerDialog(CampaignOptionActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Log.i("ALERT", "Date: " + month + " " + day + " " + year);
                        final Calendar alarmDate = Calendar.getInstance();
                        alarmDate.set(Calendar.YEAR, year);
                        alarmDate.set(Calendar.MONTH, month);
                        alarmDate.set(Calendar.DAY_OF_MONTH, day);

                        TimePickerDialog notificationTime = new TimePickerDialog(CampaignOptionActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                                Log.i("ALERT", "Time: " + hour + " " + minute);
                                alarmDate.set(Calendar.HOUR, hour);
                                alarmDate.set(Calendar.MINUTE, minute);
                                PollService.setServiceAlarm(CampaignOptionActivity.this, true, alarmDate);
                            }
                        }, 12, 00, false);
                        notificationTime.show();
                    }
                }, tempCalendar.get(Calendar.YEAR), tempCalendar.get(Calendar.MONTH), tempCalendar.get(Calendar.DAY_OF_MONTH));
                notificationDate.setTitle("Campaign Prep Reminder");
                notificationDate.show();
                break;
            default:

        }
        return true;
    }
}
