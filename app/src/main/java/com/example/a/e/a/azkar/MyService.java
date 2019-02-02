package com.example.a.e.a.azkar;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class MyService extends Service {

    AlarmManager alarmManager, alarmManager1;
    PendingIntent pendingIntent, pendingIntent1;

    private String Fajr, Zhr, Asr, Magrib, Isha;

    private SharedPreferences sharedPreferences;

    String zhrHour;
    String zhrMin;
    String zhrtime;

    private int recode1 = -1, recode2 = -1;

    Handler hNpray;
    Runnable runnable;

    private static final int uniqeID = 2342134;


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(getApplicationContext(), "service working", Toast.LENGTH_LONG).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        hNpray = new Handler();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        if (intent != null) {
            recode1 = intent.getIntExtra("requestCode", 1);

        }

        if (recode1 == 1) {

            boolean nstate = sharedPreferences.getBoolean("nState", false);

            if (nstate) {

                npray();
            }

        }

        /*if (intent != null) {
            recode1 = intent.getIntExtra("requestCode", 100);

            recode2 = intent.getIntExtra("requestCode", 101);
        }

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        GetPrayingTimes(getApplicationContext());

        //Toast.makeText(getApplicationContext(),, Toast.LENGTH_LONG).show();

        try {


            if (recode1 == 100) {

                boolean azanstate = sharedPreferences.getBoolean("azanButton", false);

                if (azanstate) {

                    StartAzanBroadMethod(17, SetFajrTime());

                    StartAzanBroadMethod(18, SetZhrTime());

                    StartAzanBroadMethod(19, SetAsrTime());

                    StartAzanBroadMethod(20, SetMagribTime());

                    StartAzanBroadMethod(21, SetIshaTime());

                } else {

                    CancalAzanAlarm();
                    CancalFajrAlarm();

                }

            } else if (recode2 == 101) {

                boolean nstate = sharedPreferences.getBoolean("nState", false);


                if (nstate) {

                    //StartNNoti();

                } else {
                    //CancleNNoti();
                }

            }

        } catch (Exception ignored) {

        }

        SetZhrTime();

        /*Toast.makeText(getApplicationContext(),zhrHour, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),zhrMin, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),zhrtime, Toast.LENGTH_LONG).show();*/

        //CheckWorkingService();


        return START_STICKY;
        //return super.onStartCommand(intent, flags, startId);
    }

    private void npray() {

        Calendar now = Calendar.getInstance();
        Calendar nextHour = Calendar.getInstance();
        nextHour.add(Calendar.HOUR, 1);
        nextHour.set(Calendar.MINUTE, 0);
        nextHour.set(Calendar.SECOND, 0);

        long difference = nextHour.getTimeInMillis() - now.getTimeInMillis();

        final int repeat_hour = 3600000; //milliseconds


        runnable = new Runnable() {
            @Override
            public void run() {

                int[] list = {R.raw.n_1, R.raw.n_2, R.raw.n_3, R.raw.n_4, R.raw.n_5, R.raw.n_6, R.raw.n_7, R.raw.n_8, R.raw.n_9, R.raw.n_10, R.raw.n_11, R.raw.n_12, R.raw.n_13};
                Random r = new Random();
                int i = list[r.nextInt(list.length)];

                Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

                String mCHANNEL_ID = "my_channel_02";// The id of the channel.
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

                assert manager != null;
                manager.notify(uniqeID, notification.build());


                hNpray.postDelayed(this, 10000);


            }
        };

        hNpray.postDelayed(runnable, 5000);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //hNpray.removeMessages(0);
        //hNpray.removeCallbacksAndMessages(null);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean nstate = sharedPreferences.getBoolean("nState", false);

        if (!nstate) {

            hNpray.removeCallbacks(runnable);
        }
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {

        if (rootIntent != null) {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            boolean nstate = sharedPreferences.getBoolean("nState", false);


            if (nstate) {

            /*Intent intent = new Intent(getApplicationContext(), MyService.class);

            int RC = 1;

            intent.putExtra("requestCode", RC);


            startService(intent);*/

                //}
                Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
                restartServiceIntent.setPackage(getPackageName());

                PendingIntent restartServicePendingIntent = PendingIntent.getService(getApplicationContext(), 1, restartServiceIntent, PendingIntent.FLAG_ONE_SHOT);
                AlarmManager alarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                assert alarmService != null;
                alarmService.set(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis(),
                        restartServicePendingIntent);

            }
        }
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Calendar SetFajrTime() {

        String fajrHour = Fajr.substring(0, 2);
        String fajrMin = Fajr.substring(3, 5);
        //String fajrtime = Fajr.substring(6,8);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(fajrHour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(fajrMin));
        calendar.set(Calendar.SECOND, 1);

        return calendar;
    }

    private Calendar SetZhrTime() {

        zhrHour = Zhr.substring(0, 2);
        zhrMin = Zhr.substring(3, 5);
        zhrtime = Zhr.substring(6, 8);

        Calendar calendar = Calendar.getInstance();

        int hour = Integer.parseInt(zhrHour);

        calendar.set(Calendar.HOUR_OF_DAY, hour);

        /*if (zhrtime.equals("AM")) {
            calendar.set(Calendar.HOUR_OF_DAY,hour );
        } else if (zhrtime.equals("PM")&&hour>=12){
            calendar.set(Calendar.HOUR_OF_DAY, hour);
        }else if (zhrtime.equals("PM")&&hour<12){
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(zhrHour) + 12);
        }*/

        calendar.set(Calendar.MINUTE, Integer.parseInt(zhrMin));
        calendar.set(Calendar.SECOND, 1);


        return calendar;
    }

    private Calendar SetAsrTime() {

        String asrHour = Asr.substring(0, 2);
        String asrMin = Asr.substring(3, 5);
        //String asrtime = Asr.substring(6,8);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(asrHour) + 12);
        calendar.set(Calendar.MINUTE, Integer.parseInt(asrMin));
        calendar.set(Calendar.SECOND, 1);

        return calendar;
    }

    private Calendar SetMagribTime() {

        String magribHour = Magrib.substring(0, 2);
        String magribMin = Magrib.substring(3, 5);
        //String magribtime = Magrib.substring(6,8);


        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(magribHour) + 12);
        calendar.set(Calendar.MINUTE, Integer.parseInt(magribMin));
        calendar.set(Calendar.SECOND, 1);
        //calendar.set(Calendar.AM_PM, Integer.parseInt(magribtime));

        return calendar;
    }

    private Calendar SetIshaTime() {

        String ishaHour = Isha.substring(0, 2);
        String ishaMin = Isha.substring(3, 5);
        //String ishatime = Isha.substring(6,8);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(ishaHour) + 12);
        calendar.set(Calendar.MINUTE, Integer.parseInt(ishaMin));
        calendar.set(Calendar.SECOND, 1);
        //calendar.set(Calendar.AM_PM, Integer.parseInt(ishatime));

        return calendar;
    }


    private void StartAzanBroadMethod(int RC, Calendar time) {

        Intent intent17 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        intent17.putExtra("requestCode", RC);

        pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), RC, intent17, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (System.currentTimeMillis() < time.getTimeInMillis()) {
            alarmManager1.set(AlarmManager.RTC_WAKEUP, time.getTimeInMillis(), pendingIntent1);
        }
    }


    private void GetPrayingTimes(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Fajr = sharedPreferences.getString("fajr", " ");
        Zhr = sharedPreferences.getString("zhr", " ");
        Asr = sharedPreferences.getString("asr", " ");
        Magrib = sharedPreferences.getString("magrib", " ");
        Isha = sharedPreferences.getString("isha", " ");


    }

    private void CancalFajrAlarm() {

        Intent intent17 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        int RC = 17;

        intent17.putExtra("requestCode", RC);

        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent17, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);

    }

    private void CancalAzanAlarm() {

        Intent intent18 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        int RC = 18;

        intent18.putExtra("requestCode", RC);

        pendingIntent1 = PendingIntent.getBroadcast(getApplicationContext(), RC, intent18, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager1.cancel(pendingIntent1);

    }

    private void StartNNoti() {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        Intent intent1 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        int RC = 1;

        intent1.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, hour, AlarmManager.INTERVAL_HOUR, pendingIntent);

    }

    private void CancleNNoti() {

        Intent intent1 = new Intent(getApplicationContext(), AlarmAzkarBroad.class);

        int RC = 1;

        intent1.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), RC, intent1, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.cancel(pendingIntent);

    }

    /*private void CheckWorkingService() {

        boolean nstate = sharedPreferences.getBoolean("nState", false);

        boolean azanstate = sharedPreferences.getBoolean("azanButton", false);

        if (!nstate && !azanstate) {

            stopService(new Intent(getApplicationContext(), MyService.class));
        }

    }*/


}

