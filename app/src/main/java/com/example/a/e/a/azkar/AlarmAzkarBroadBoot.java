package com.example.a.e.a.azkar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Random;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Doctors-AEA on 10/29/2016.
 */

public class AlarmAzkarBroadBoot extends BroadcastReceiver {

    Handler h;
    Runnable runnable;

    private static final int uniqeID = 234234;

    private void StartBootAzkar(Context context, int hour, int min, int sec, int RC) {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, sec);

        Intent intent = new Intent(context, AlarmAzkarBroad.class);

        intent.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        if (System.currentTimeMillis() < calendar.getTimeInMillis()) {

            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        }

    }

    @Override
    public void onReceive(final Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {


            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

            boolean nstate = sharedPreferences.getBoolean("nState", false);


            if (nstate) {

                startSerivce(context);

            }

            boolean rstate = sharedPreferences.getBoolean("rState", false);


            if (rstate) {

                StartBootAzkar(context, 7, 30, 1, 2);

            }

            boolean sstate = sharedPreferences.getBoolean("sState", false);


            if (sstate) {

                StartBootAzkar(context, 8, 30, 1, 3);

            }

            boolean hstate = sharedPreferences.getBoolean("hState", false);


            if (hstate) {

                StartBootAzkar(context, 9, 30, 1, 4);

            }

            boolean wstate = sharedPreferences.getBoolean("wState", false);


            if (wstate) {

                StartBootAzkar(context, 10, 30, 1, 5);

            }

            boolean ostate = sharedPreferences.getBoolean("oState", false);


            if (ostate) {

                StartBootAzkar(context, 11, 30, 1, 6);

            }

            boolean estate = sharedPreferences.getBoolean("eState", false);


            if (estate) {

                StartBootAzkar(context, 19, 30, 1, 7);

            }

            boolean gstate = sharedPreferences.getBoolean("gState", false);


            if (gstate) {

                StartBootAzkar(context, 20, 30, 1, 8);

            }

            boolean tstate = sharedPreferences.getBoolean("tState", false);


            if (tstate) {

                StartBootAzkar(context, 21, 30, 1, 9);

            }

            boolean cstate = sharedPreferences.getBoolean("cState", false);


            if (cstate) {

                StartBootAzkar(context, 22, 30, 1, 10);

            }

            boolean ystate = sharedPreferences.getBoolean("yState", false);


            if (ystate) {

                StartBootAzkar(context, 23, 30, 1, 11);

            }


            boolean fstate = sharedPreferences.getBoolean("fState", false);

            if (fstate) {

                StartBootAzkar(context, 15, 30, 1, 12);

            }


            boolean zstate = sharedPreferences.getBoolean("zstate", false);

            if (zstate) {

                int repeat = 1000 * 60 * 5;

                Intent intent13 = new Intent(context, AlarmAzkarBroad.class);

                int RC = 13;

                intent13.putExtra("requestCode", RC);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, RC, intent13, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), repeat, pendingIntent);

            }

            boolean jstate = sharedPreferences.getBoolean("jstate", false);


            if (jstate) {

                StartBootAzkar(context, 4, 15, 1, 14);

            }


            boolean astate = sharedPreferences.getBoolean("astate", false);


            if (astate) {

                StartBootAzkar(context, 16, 15, 1, 15);

            }

            boolean lstate = sharedPreferences.getBoolean("lstate", false);

            if (lstate) {

                StartBootAzkar(context, 23, 15, 1, 16);

            }

            boolean azanstate = sharedPreferences.getBoolean("azanButton", false);

            if (azanstate) {

                Intent intent1 = new Intent(context, MyService.class);

                context.startService(intent1);
            }
        }
    }

    public void npray(Context context) {

        int[] list = {R.raw.n_1, R.raw.n_2, R.raw.n_3, R.raw.n_4, R.raw.n_5, R.raw.n_6, R.raw.n_7, R.raw.n_8, R.raw.n_9, R.raw.n_10, R.raw.n_11, R.raw.n_12, R.raw.n_13};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        String mCHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = "Hello";// The user-visible name of the channel.
        NotificationChannel mChannel;

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, mCHANNEL_ID);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("صل على النبى");
        notification.setContentText("اللهم صل على محمد و على ال محمد");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent1 = new Intent(context, Azkar_Main.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


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


    }

    public void startSerivce(Context context) {

        /*Intent restartServiceIntent = new Intent(context,MyService.class);
        restartServiceIntent.setPackage(context.getPackageName());

        PendingIntent restartServicePendingIntent = PendingIntent.getService(context, 1, restartServiceIntent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmService = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        assert alarmService != null;
        alarmService.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                restartServicePendingIntent);*/

        Intent intent = new Intent(context, MyService.class);

        int RC = 1;

        intent.putExtra("requestCode", RC);

        PendingIntent pendingIntent = PendingIntent.getService(context, RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);

        assert alarmManager != null;
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pendingIntent);


        Toast.makeText(context, "Working on boot", Toast.LENGTH_LONG).show();


        /*Intent intent = new Intent(context, MyService.class);

        int RC = 1;

        intent.putExtra("requestCode", RC);

        context.startService(intent);*/


    }


}
