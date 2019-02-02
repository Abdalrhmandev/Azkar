package com.example.a.e.a.azkar;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.view.Display;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.Random;

import static android.content.Context.POWER_SERVICE;

/**
 * Created by Doctors-AEA on 10/29/2016.
 */
public class AlarmAzkarBroad extends BroadcastReceiver {

    private static final int uniqeID = 234234;

    private static final int uniqeazanID = 123123;

    AudioManager audioManager;

    String mCHANNEL_ID = "my_channel_01";// The id of the channel.
    CharSequence name = "";// The user-visible name of the channel.
    NotificationChannel mChannel;

    @Override
    public void onReceive(Context context, Intent intent) {

        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);


        int recode1 = intent.getIntExtra("requestCode", 1);
        int recode2 = intent.getIntExtra("requestCode", 2);
        int recode3 = intent.getIntExtra("requestCode", 3);
        int recode4 = intent.getIntExtra("requestCode", 4);
        int recode5 = intent.getIntExtra("requestCode", 5);
        int recode6 = intent.getIntExtra("requestCode", 6);
        int recode7 = intent.getIntExtra("requestCode", 7);
        int recode8 = intent.getIntExtra("requestCode", 8);
        int recode9 = intent.getIntExtra("requestCode", 9);
        int recode10 = intent.getIntExtra("requestCode", 10);
        int recode11 = intent.getIntExtra("requestCode", 11);
        int recode12 = intent.getIntExtra("requestCode", 12);


        int recode13 = intent.getIntExtra("requestCode", 13);
        int recode14 = intent.getIntExtra("requestCode", 14);
        int recode15 = intent.getIntExtra("requestCode", 15);
        int recode16 = intent.getIntExtra("requestCode", 16);

        int recode17 = intent.getIntExtra("requestCode", 17);
        int recode18 = intent.getIntExtra("requestCode", 18);
        int recode19 = intent.getIntExtra("requestCode", 19);
        int recode20 = intent.getIntExtra("requestCode", 20);
        int recode21 = intent.getIntExtra("requestCode", 21);


        if (recode1 == 1) {
            //npray(context);
        } else if (recode2 == 2) {
            rpray(context);
        } else if (recode3 == 3) {
            spray(context);
        } else if (recode4 == 4) {
            hpray(context);
        } else if (recode5 == 5) {
            wpray(context);
        } else if (recode6 == 6) {
            opray(context);
        } else if (recode7 == 7) {
            epray(context);
        } else if (recode8 == 8) {
            gpray(context);
        } else if (recode9 == 9) {
            tpray(context);
        } else if (recode10 == 10) {
            cpray(context);
        } else if (recode11 == 11) {
            ypray(context);
        } else if (recode12 == 12) {
            fpray(context);
        } else if (recode13 == 13) {
            znoti(context);
        } else if (recode14 == 14) {
            jnoti(context);
        } else if (recode15 == 15) {
            anoti(context);
        } else if (recode16 == 16) {
            lnoti(context);
        } else if (recode17 == 17) {
            AzanFajrNoti(context);
        } else if (recode18 == 18) {
            AzanNoti(context);
        } else if (recode19 == 19) {
            AzanNoti(context);
        } else if (recode20 == 20) {
            AzanNoti(context);
        } else if (recode21 == 21) {
            AzanNoti(context);
        }
    }

    public void AzanNoti(Context context) {

        if (audioManager.getRingerMode() == AudioManager.RINGER_MODE_NORMAL) {
            audioManager.setStreamVolume(AudioManager.STREAM_RING, 7, AudioManager.FLAG_ALLOW_RINGER_MODES | AudioManager.FLAG_PLAY_SOUND);
        }


        int[] list = {R.raw.azan1, R.raw.azan2, R.raw.azan3, R.raw.azan4};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("الصلاة الصلاة");
        notification.setContentText("الصلاة الصلاة و ما ملكت أيمانكم ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent2 = new Intent(context, PrayingTimes.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri,attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }

        assert manager != null;
        manager.notify(uniqeazanID, notification.build());


    }

    public void AzanFajrNoti(Context context) {

        if (audioManager.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            audioManager.setStreamVolume(AudioManager.STREAM_RING, 7, AudioManager.FLAG_ALLOW_RINGER_MODES | AudioManager.FLAG_PLAY_SOUND);
        }

        int[] list = {R.raw.fajr1, R.raw.fajr2};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("الصلاة الصلاة");
        notification.setContentText("الصلاة الصلاة و ما ملكت أيمانكم ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent2 = new Intent(context, PrayingTimes.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri,attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }

        assert manager != null;
        manager.notify(uniqeazanID, notification.build());


    }

    public void rpray(Context context) {

        int[] list = {R.raw.mr_71, R.raw.mr_72};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("اللهم انى اسئلك علما نافعا و رزقا طيبا و عملا متقبلا ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent2 = new Intent(context, Azkar_Main.class);
        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri,attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }


        assert manager != null;
        manager.notify(uniqeID, notification.build());


    }

    public void spray(Context context) {

        int[] list = {R.raw.ms_81, R.raw.ms_82};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("اللهم عافنى فى بدنى . اللهم عافنى فى سمعى ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent3 = new Intent(context, Azkar_Main.class);
        intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 3, intent3, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri,attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }


        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void hpray(Context context) {

        int[] list = {R.raw.mh_91, R.raw.mh_92};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("يا حى يا قيوم برحمتك استغيث ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent4 = new Intent(context, Azkar_Main.class);
        intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 4, intent4, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri,attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }


        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void wpray(Context context) {

        int[] list = {R.raw.mw_101, R.raw.mw_102};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("بسم الله الذى لا يضر مع اسمه شئ ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent5 = new Intent(context, Azkar_Main.class);
        intent5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 5, intent5, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();

            int importance = NotificationManager.IMPORTANCE_HIGH;
            mChannel = new NotificationChannel(mCHANNEL_ID, name, importance);

            mChannel.setSound(uri,attributes);

            assert manager != null;
            manager.createNotificationChannel(mChannel);
        }


        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void opray(Context context) {

        int[] list = {R.raw.mo_111, R.raw.mo_112};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("حسبى الله لا اله الا هو عليه توكلت ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent6 = new Intent(context, Azkar_Main.class);
        intent6.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 6, intent6, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void epray(Context context) {

        int[] list = {R.raw.ne_71, R.raw.ne_72};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("رضيت باله ربا و بالاسلام دينا ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent7 = new Intent(context, Azkar_Main.class);
        intent7.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 7, intent7, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void gpray(Context context) {

        int[] list = {R.raw.ng_81, R.raw.ng_82, R.raw.ng_83};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("لا اله الا الله وحده لا شريك له ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent8 = new Intent(context, Azkar_Main.class);
        intent8.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 8, intent8, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void tpray(Context context) {

        int[] list = {R.raw.nt_91, R.raw.nt_92, R.raw.nt_93, R.raw.nt_94, R.raw.nt_95, R.raw.nt_96};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("سبحان الله و بحمده ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent9 = new Intent(context, Azkar_Main.class);
        intent9.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 9, intent9, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void cpray(Context context) {

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + R.raw.nc_10);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("اعوذ بكلمات الله التامات ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent10 = new Intent(context, Azkar_Main.class);
        intent10.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 10, intent10, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void ypray(Context context) {

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + R.raw.ny_11);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("اللهم انت ربى لا اله الا انت ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent11 = new Intent(context, Azkar_Main.class);
        intent11.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 11, intent11, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void fpray(Context context) {

        int[] list = {R.raw.af_31, R.raw.af_32};
        Random r = new Random();
        int i = list[r.nextInt(list.length)];

        Uri uri = Uri.parse("android.resource://" + "com.example.a.e.a.azkar" + "/" + i);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكر الله");
        notification.setContentText("استغفر الله و اتوب اليه ..... ");
        notification.setContentTitle("Azkar");
        notification.setSound(uri);

        Intent intent12 = new Intent(context, Azkar_Main.class);
        intent12.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 12, intent12, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void znoti(Context context) {

        if (Build.VERSION.SDK_INT >= 20) {

            DisplayManager displayManager = (DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE);
            for (Display display : displayManager.getDisplays()) {
                if (display.getState() == Display.STATE_ON) {


                    String[] list = {
                            "سبحان الله و الحمد لله و لا اله الا الله و الله اكبر",
                            "سبحان الله",
                            "الحمد لله",
                            "لا اله الا الله",
                            "االله اكبر",
                            "سبحان الله و بحمده",
                            "سبحان الله العظيم",
                            "سبحان الله و بحمده سبحان الله العظيم",
                            "اللهم صلى و سلم على نبينا محمد ",
                            "استغفر الله الحى القيوم الذى لا اله الا هو الحى القيوم و اتوب اليه",
                            "استغفر الله العظيم",
                            "استغفر الله العظيم و اتوب اليه",
                            "اشهد ان لا اله الا الله و ان محمد عبده و رسوله",
                            "اشهد ان لا اله الا الله وحده لا شريك له",
                            "اعوذ بكلمات الله التامات من شر ما خلق",
                            "اعوذ بالله من الشيطان من نفحه و نفثه و همزه",
                            "اللهم اسلمت نفسى اليك",
                            "اللهم فوضت امرى اليك",
                            "اللهم لا ملجأ ولا منجا منك الا اليك",
                            "اللهم اعنى على ذكرك و شكرك و حسن عبادتك",
                            "اللهم انت السلام و منك السلام تباركت يا ذا الجلال و الاكرام",
                            "اللهم انت ربى لا اله الا انت عليك توكلت و انت رب العرش العظيم",
                            "اللهم انت ربى لا اله الا انت خلقتنى و انا عبدك",
                            "اللهم انى اسئلك العفو و العافيه فى الدنيا و الاخره",
                            "اللهم انى اسئلك العفو و العافيه فى دينى و دنياى و اهلى و مالى",
                            "اللهم انى اسئلك علما نافعا",
                            "اللهم انى اسئلك علما نافعا و رزقا طيبا و عملا متقبلا",
                            "اللهم انى اسئلك عملا متقبلا",
                            "اللهم انى اسئلك رزقا طيبا",
                            "اللهم انى اعوذ بك من الكفر والفقر و اعوذ بك من عذاب القبر",
                            "اللهم اغفر لنا ما اسررنا وما اعلنا",
                            "اللهم انك عفو كريم تحب العفو فاعف عنى",
                            "اللهم قنى يوم تبعث عبادك",
                            "اللهم لك الحمد كما ينبغى لجلال وجهك و عظيم سلطانك",
                            "اللهم انى اسئلك الهدى و التقى و العفاف و الغنى",
                            "حسبنا الله و نعم الوكيل",
                            "رب انى مسنى الضر و انت ارحم الرحمين",
                            "رب اشرح لى صدرى و يسر لى امرى",
                            "رب اغفر لى و تب على",
                            "رب اغفر و ارحم و تجاوز عما تعلم",
                            "رب انزلنى منزلا مباركا و انت خير المنزلين",
                            "ربنا عليك توكلنا واليك المصير",
                            "لا اله الا انت سبجانك انى كنت من الظالمين",
                            "لا حول ولا قوه الا بالله",
                            "يا حى يا قيوم برحمتك استغيث"

                    };
                    Random random = new Random();

                    String text2 = list[random.nextInt(list.length)];

                    TastyToast.makeText(context, text2, TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

                    return;
                }


            }


        } else {

            PowerManager powerManager = (PowerManager) context.getSystemService(POWER_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH && powerManager.isInteractive() || Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT_WATCH && powerManager.isScreenOn()) {

                String[] list = {
                        "سبحان الله و الحمد لله و لا اله الا الله و الله اكبر",
                        "سبحان الله",
                        "الحمد لله",
                        "لا اله الا الله",
                        "االله اكبر",
                        "سبحان الله و بحمده",
                        "سبحان الله العظيم",
                        "سبحان الله و بحمده سبحان الله العظيم",
                        "اللهم صلى و سلم على نبينا محمد ",
                        "استغفر الله الحى القيوم الذى لا اله الا هو الحى القيوم و اتوب اليه",
                        "استغفر الله العظيم",
                        "استغفر الله العظيم و اتوب اليه",
                        "اشهد ان لا اله الا الله و ان محمد عبده و رسوله",
                        "اشهد ان لا اله الا الله وحده لا شريك له",
                        "اعوذ بكلمات الله التامات من شر ما خلق",
                        "اعوذ بالله من الشيطان من نفحه و نفثه و همزه",
                        "اللهم اسلمت نفسى اليك",
                        "اللهم فوضت امرى اليك",
                        "اللهم لا ملجأ ولا منجا منك الا اليك",
                        "اللهم اعنى على ذكرك و شكرك و حسن عبادتك",
                        "اللهم انت السلام و منك السلام تباركت يا ذا الجلال و الاكرام",
                        "اللهم انت ربى لا اله الا انت عليك توكلت و انت رب العرش العظيم",
                        "اللهم انت ربى لا اله الا انت خلقتنى و انا عبدك",
                        "اللهم انى اسئلك العفو و العافيه فى الدنيا و الاخره",
                        "اللهم انى اسئلك العفو و العافيه فى دينى و دنياى و اهلى و مالى",
                        "اللهم انى اسئلك علما نافعا",
                        "اللهم انى اسئلك علما نافعا و رزقا طيبا و عملا متقبلا",
                        "اللهم انى اسئلك عملا متقبلا",
                        "اللهم انى اسئلك رزقا طيبا",
                        "اللهم انى اعوذ بك من الكفر والفقر و اعوذ بك من عذاب القبر",
                        "اللهم اغفر لنا ما اسررنا وما اعلنا",
                        "اللهم انك عفو كريم تحب العفو فاعف عنى",
                        "اللهم قنى يوم تبعث عبادك",
                        "اللهم لك الحمد كما ينبغى لجلال وجهك و عظيم سلطانك",
                        "اللهم انى اسئلك الهدى و التقى و العفاف و الغنى",
                        "حسبنا الله و نعم الوكيل",
                        "رب انى مسنى الضر و انت ارحم الرحمين",
                        "رب اشرح لى صدرى و يسر لى امرى",
                        "رب اغفر لى و تب على",
                        "رب اغفر و ارحم و تجاوز عما تعلم",
                        "رب انزلنى منزلا مباركا و انت خير المنزلين",
                        "ربنا عليك توكلنا واليك المصير",
                        "لا اله الا انت سبجانك انى كنت من الظالمين",
                        "لا حول ولا قوه الا بالله",
                        "يا حى يا قيوم برحمتك استغيث"

                };
                Random random = new Random();

                String text2 = list[random.nextInt(list.length)];

                TastyToast.makeText(context, text2, TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

            }

        }


    }

    public void jnoti(Context context) {


        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكار الصباح و صلاة الفجر اذا لم تصلى");
        notification.setContentText("اذكار الصباح و صلاة الفجر اذا لم تصلى");
        notification.setContentTitle("Azkar");
        notification.setDefaults(Notification.DEFAULT_SOUND);


        Intent intent14 = new Intent(context, MorningAzkarActivity.class);
        intent14.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 14, intent14, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void anoti(Context context) {


        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكار المساء و صلاة العصر اذا لم تصلى");
        notification.setContentText("اذكار المساء و صلاة العصر اذا لم تصلى");
        notification.setContentTitle("Azkar");
        notification.setDefaults(Notification.DEFAULT_SOUND);


        Intent intent15 = new Intent(context, NightAzkarActivity.class);
        intent15.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 15, intent15, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }

    public void lnoti(Context context) {

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setSmallIcon(R.mipmap.noti_icona);
        notification.setTicker("اذكار قبل النوم");
        notification.setContentText("اقرأ معلومه جديده من الصفحه الرئيسية قبل النوم");
        notification.setContentTitle("Azkar");
        notification.setDefaults(Notification.DEFAULT_SOUND);


        Intent intent16 = new Intent(context, Azkar_Main.class);
        intent16.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 16, intent16, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        assert manager != null;
        manager.notify(uniqeID, notification.build());

    }


}


