package com.example.a.e.a.azkar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

import java.util.Calendar;

public class TextNoti_Activity extends Azkar_Main {

    Toolbar toolbar;
    ToggleButton ztoggleButton, jtoggleButton, atoggleButton, ltoggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_content);
        getLayoutInflater().inflate(R.layout.activity_text_noti_, frameLayout);


        toolbar = (Toolbar) findViewById(R.id.navi_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ztoggleButton = (ToggleButton) findViewById(R.id.zToggleB);
        jtoggleButton = (ToggleButton) findViewById(R.id.jToggleB);
        atoggleButton = (ToggleButton) findViewById(R.id.aToggleB);
        ltoggleButton = (ToggleButton) findViewById(R.id.lToggleB);


        getState(getApplicationContext());

    }

    private void StartTextNoti(int hour , int min , int sec , int RC , String stateStartKey){

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, sec);

        Intent intent = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        intent.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (calendar.getTimeInMillis()>System.currentTimeMillis()) {

            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        }

        saveState(stateStartKey, true, getApplicationContext());

    }

    private void CancleTextNoti (int RC , String stateCancleKey){

        Intent intent = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        intent.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);

        saveState(stateCancleKey, false, getApplicationContext());

    }

    @Override
    protected void onStart() {
        super.onStart();

        toggleActoin();
    }

    public void toggleActoin() {

        ztoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    int repeat = 1000 * 60 * 4;

                    Intent intent13 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

                    int RC = 13;

                    intent13.putExtra("requestCode", RC);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent13, PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), repeat, pendingIntent);

                    saveState("zstate", true, getApplicationContext());
                } else {

                    CancleTextNoti(13,"zstate");

                }
            }
        });
        jtoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartTextNoti(4,15,1,14,"jstate");

                } else {

                    CancleTextNoti(14,"jstate");

                }
            }
        });
        atoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartTextNoti(16,15,1,15,"astate");

                } else {

                    CancleTextNoti(15,"astate");

                }
            }
        });
        ltoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartTextNoti(23,15,1,16,"lstate");

                } else {

                    CancleTextNoti(16,"lstate");

                }
            }
        });

    }

    public void saveState(String key, boolean value, Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();

    }

    public void getState(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean zstate = sharedPreferences.getBoolean("zstate", false);

        if (zstate) {

            ztoggleButton.setChecked(true);

        } else {
            ztoggleButton.setChecked(false);
        }

        boolean jstate = sharedPreferences.getBoolean("jstate", false);

        if (jstate) {

            jtoggleButton.setChecked(true);

        } else {
            jtoggleButton.setChecked(false);
        }

        boolean astate = sharedPreferences.getBoolean("astate", false);

        if (astate) {

            atoggleButton.setChecked(true);

        } else {
            atoggleButton.setChecked(false);
        }

        boolean lstate = sharedPreferences.getBoolean("lstate", false);

        if (lstate) {

            ltoggleButton.setChecked(true);

        } else {
            ltoggleButton.setChecked(false);
        }


    }


}
