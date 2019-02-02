package com.example.a.e.a.azkar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Random;

public class VoiceNotiActivity extends Azkar_Main {

    ToggleButton ntoggleButton, rtoggleButton, stoggleButton, htoggleButton, wtoggleButton, otoggleButton,
            etoggleButton, gtoggleButton, ttoggleButton, ctoggleButton, ytoggleButton, ftoggleButton;

    private static final int uniqeID = 234234;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = findViewById(R.id.frame_content);
        getLayoutInflater().inflate(R.layout.activity_voicenoti, frameLayout);


        ntoggleButton = findViewById(R.id.nToggleB);
        rtoggleButton = findViewById(R.id.rToggleB);
        stoggleButton = findViewById(R.id.sToggleB);
        htoggleButton = findViewById(R.id.hToggleB);
        wtoggleButton = findViewById(R.id.wToggleB);
        otoggleButton = findViewById(R.id.oToggleB);
        etoggleButton = findViewById(R.id.eToggleB);
        gtoggleButton = findViewById(R.id.gToggleB);
        ttoggleButton = findViewById(R.id.tToggleB);
        ctoggleButton = findViewById(R.id.cToggleB);
        ytoggleButton = findViewById(R.id.yToggleB);
        ftoggleButton = findViewById(R.id.fToggleB);


        getState(getApplicationContext());


    }

    private void StartVoiceAlarm(int hour, int min, int sec, int RC, String stateStartKey) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, sec);

        Intent intent = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        intent.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (System.currentTimeMillis() < calendar.getTimeInMillis()) {

            assert alarmManager != null;
            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        }

        saveState(stateStartKey, true, getApplicationContext());

    }

    private void CancleVoiceAlarm(int RC, String stateCancleKey) {

        Intent intent = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        intent.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.cancel(pendingIntent);

        saveState(stateCancleKey, false, getApplicationContext());
    }


    @Override
    protected void onStart() {

        super.onStart();

        ntoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    saveState("nState", true, getApplicationContext());

                    /*Calendar now = Calendar.getInstance();
                    Calendar nextHour = Calendar.getInstance();
                    nextHour.add(Calendar.HOUR, 1);
                    nextHour.set(Calendar.MINUTE, 0);
                    nextHour.set(Calendar.SECOND, 0);

                    long difference = nextHour.getTimeInMillis() - now.getTimeInMillis();


                    final long repeat_hour = 3600000; //milliseconds



                    runnable = new Runnable() {
                        @Override
                        public void run() {

                            npray();

                            h.postDelayed(this, repeat_hour);

                            Toast.makeText(getApplicationContext(),String.valueOf(repeat_hour),Toast.LENGTH_LONG).show();

                        }
                    };

                    h.postDelayed(runnable,difference);*/


                    Intent intent = new Intent(getApplicationContext(), MyService.class);

                    int RC = 1;

                    intent.putExtra("requestCode", RC);

                    startService(intent);


                } else {

                    saveState("nState", false, getApplicationContext());

                    Intent intent = new Intent(getApplicationContext(), MyService.class);

                    int RC = 1;

                    intent.putExtra("requestCode", RC);

                    stopService(intent);
                }
            }
        });


        rtoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(7, 30, 1, 2, "rState");

                } else {

                    CancleVoiceAlarm(2, "rState");

                }
            }
        });


        stoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(8, 30, 1, 3, "sState");

                } else {

                    CancleVoiceAlarm(3, "sState");

                }
            }
        });


        htoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(9, 30, 1, 4, "hState");

                } else {

                    CancleVoiceAlarm(4, "hState");

                }
            }
        });


        wtoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(10, 30, 1, 5, "wState");

                } else {

                    CancleVoiceAlarm(5, "wState");

                }
            }
        });


        otoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(11, 30, 1, 6, "oState");

                } else {

                    CancleVoiceAlarm(6, "oState");

                }
            }
        });


        etoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(19, 30, 1, 7, "eState");

                } else {

                    CancleVoiceAlarm(7, "eState");

                }
            }
        });

        gtoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(20, 30, 1, 8, "gState");

                } else {

                    CancleVoiceAlarm(8, "gState");

                }
            }
        });


        ttoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(21, 30, 1, 9, "tState");

                } else {

                    CancleVoiceAlarm(9, "tState");

                }
            }
        });


        ctoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(22, 30, 1, 10, "cState");

                } else {

                    CancleVoiceAlarm(10, "cState");

                }
            }
        });

        ytoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(23, 30, 1, 11, "yState");

                } else {

                    CancleVoiceAlarm(11, "yState");

                }
            }
        });


        ftoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    StartVoiceAlarm(15, 30, 1, 12, "fState");

                } else {

                    CancleVoiceAlarm(12, "fState");

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
        boolean nstate = sharedPreferences.getBoolean("nState", false);

        if (nstate) {

            ntoggleButton.setChecked(true);

        } else {
            ntoggleButton.setChecked(false);
        }

        boolean rstate = sharedPreferences.getBoolean("rState", false);
        if (rstate) {
            rtoggleButton.setChecked(true);
        } else {
            rtoggleButton.setChecked(false);
        }

        boolean sstate = sharedPreferences.getBoolean("sState", false);
        if (sstate) {
            stoggleButton.setChecked(true);
        } else {
            stoggleButton.setChecked(false);
        }

        boolean hstate = sharedPreferences.getBoolean("hState", false);
        if (hstate) {
            htoggleButton.setChecked(true);
        } else {
            htoggleButton.setChecked(false);
        }

        boolean wstate = sharedPreferences.getBoolean("wState", false);
        if (wstate) {
            wtoggleButton.setChecked(true);
        } else {
            wtoggleButton.setChecked(false);
        }

        boolean ostate = sharedPreferences.getBoolean("oState", false);
        if (ostate) {
            otoggleButton.setChecked(true);
        } else {
            otoggleButton.setChecked(false);
        }

        boolean estate = sharedPreferences.getBoolean("eState", false);
        if (estate) {
            etoggleButton.setChecked(true);
        } else {
            etoggleButton.setChecked(false);
        }

        boolean gstate = sharedPreferences.getBoolean("gState", false);
        if (gstate) {
            gtoggleButton.setChecked(true);
        } else {
            gtoggleButton.setChecked(false);
        }

        boolean tstate = sharedPreferences.getBoolean("tState", false);
        if (tstate) {
            ttoggleButton.setChecked(true);
        } else {
            ttoggleButton.setChecked(false);
        }

        boolean cstate = sharedPreferences.getBoolean("cState", false);
        if (cstate) {
            ctoggleButton.setChecked(true);
        } else {
            ctoggleButton.setChecked(false);
        }

        boolean ystate = sharedPreferences.getBoolean("yState", false);
        if (ystate) {
            ytoggleButton.setChecked(true);
        } else {
            ytoggleButton.setChecked(false);
        }

        boolean fstate = sharedPreferences.getBoolean("fState", false);
        if (fstate) {
            ftoggleButton.setChecked(true);
        } else {
            ftoggleButton.setChecked(false);
        }


    }

    public void npray() {

        int[] list = {R.raw.n_1, R.raw.n_2, R.raw.n_3, R.raw.n_4, R.raw.n_5, R.raw.n_6, R.raw.n_7, R.raw.n_8, R.raw.n_9, R.raw.n_10, R.raw.n_11, R.raw.n_12, R.raw.n_13};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        String mCHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = "Hello";// The user-visible name of the channel.
        NotificationChannel mChannel;

        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(), mCHANNEL_ID);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("صل على النبى");
        notification.setContentText("اللهم صل على محمد و على ال محمد");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent1 = new Intent(getApplicationContext(), Azkar_Main.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri, attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }

        manager.notify(uniqeID, notification.build());


    }


}
