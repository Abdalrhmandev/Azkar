package com.example.a.e.a.azkar;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class PrayingTimes extends Azkar_Main {

    int state = 0;

    //private static final String FORMAT = "%02d:%02d:%02d";

   // int seconds,minutes;

    private String Fajr, Zhr, Asr, Magrib, Isha;

    String zhrHour;
    String zhrMin;
    String zhrtime;

    private static final String PRAYING_VALUES = "values";
    private TextView txtPrayerTimes, copyLoca;
    LinearLayout changeLocLayout, prayingTimeLayout;
    EditText LogitudeEdit, LatidudeEdit;
    double latitude = 30.041802, longitude = 31.234947;
    ArrayList prayerTimes;
    ToggleButton azan_button;

    Spinner governerates;
    ArrayAdapter<CharSequence> arrayAdapter;

    TextView activateAzanText, timerCounter , selectedGovernerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout =  findViewById(R.id.frame_content);
        getLayoutInflater().inflate(R.layout.activity_praying_times, frameLayout);

        changeLocLayout = findViewById(R.id.changeLocLayout);
        prayingTimeLayout = findViewById(R.id.prayingTimeLayout);
        LatidudeEdit =  findViewById(R.id.latiTudeEdit);
        LogitudeEdit =  findViewById(R.id.longitudeEdit);
        copyLoca =  findViewById(R.id.copyloca);

        governerates =  findViewById(R.id.governerates);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.praying_location, R.layout.custom_simple_spinner_item);
        arrayAdapter.setDropDownViewResource(R.layout.custom_simple_spinner_dropdown_item);
        governerates.setAdapter(arrayAdapter);

        txtPrayerTimes = findViewById(R.id.txtPrayerTimes);
        selectedGovernerate = findViewById(R.id.selectedGovernerate);

        activateAzanText =  findViewById(R.id.activateAzanText);
        timerCounter =  findViewById(R.id.timerCounter);

        azan_button =  findViewById(R.id.azan_button);

        selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

        getVales();
        getState(getApplicationContext());
        CaluclationMethod();

        AzanButton();

        selctGovernrate();

        GetPrayingTimes(getApplicationContext());

        //counterDownTimer();

        //SetFajrTime();

        //timerCounter.setText(String.valueOf(SetFajrTime().getTimeInMillis()));


    }

    /*private void counterDownTimer(){

        Calendar now = Calendar.getInstance();

        final long difference;
        now.after(12);

        if (now.getTimeInMillis()>=SetIshaTime().getTimeInMillis()){

            long twHours = 12*60*60*1000;

            difference = (now.getTimeInMillis()- twHours) - SetFajrTime().getTimeInMillis() ;

        }else {
            difference = SetIshaTime().getTimeInMillis()-now.getTimeInMillis();
        }

        //
        //timerCounter.setText(""+difference);

        new CountDownTimer( difference ,1000){

            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onTick(long l) {

                int seconds = (int) (l/1000);

                int hours = seconds/(60*60);
                int tempMint = (seconds - (hours * 60 * 60));
                int minutes = tempMint/60 ;
                seconds = tempMint - ( minutes * 60 );

                //timerCounter.setText("Hello");

                timerCounter.setText(" " + String.format("%02d" , hours)
                        + " : " + String.format("%02d" , minutes)
                        + " : " + String.format("%02d" , seconds)

                );
            //timerCounter.setText(difference);

                timerCounter.setText(""+String.format(FORMAT, TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)));


            }

            @Override
            public void onFinish() {

                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();

            }
        }.start();


    }*/

    private void GetPrayingTimes(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        Fajr = sharedPreferences.getString("fajr", " ");
        Zhr = sharedPreferences.getString("zhr", " ");
        Asr = sharedPreferences.getString("asr", " ");
        Magrib = sharedPreferences.getString("magrib", " ");
        Isha = sharedPreferences.getString("isha", " ");


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

        calendar.set(Calendar.HOUR, hour);

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

        calendar.set(Calendar.HOUR, Integer.parseInt(asrHour) + 12);
        calendar.set(Calendar.MINUTE, Integer.parseInt(asrMin));
        calendar.set(Calendar.SECOND, 1);

        return calendar;
    }

    private Calendar SetMagribTime() {

        String magribHour = Magrib.substring(0, 2);
        String magribMin = Magrib.substring(3, 5);
        //String magribtime = Magrib.substring(6,8);


        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR, Integer.parseInt(magribHour) + 12);
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

        calendar.set(Calendar.HOUR, Integer.parseInt(ishaHour) + 12);
        calendar.set(Calendar.MINUTE, Integer.parseInt(ishaMin));
        calendar.set(Calendar.SECOND, 1);
        //calendar.set(Calendar.AM_PM, Integer.parseInt(ishatime));

        return calendar;
    }


    private void AzanButton(){
        azan_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {

                    saveState("azanButton", true, getApplicationContext());

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY, 1);
                    calendar.set(Calendar.MINUTE, 1);

                    Intent intent = new Intent(getApplicationContext(), MyService.class);

                    int RC = 100 ;

                    intent.putExtra("requestCode", RC);

                    PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                    assert alarmManager != null;
                    alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

                    /*Intent intent = new Intent(getApplicationContext(),MyService.class);

                    startService(intent);*/



                } else {

                    saveState("azanButton", false, getApplicationContext());

                    Intent intent = new Intent(getApplicationContext(), MyService.class);

                    int RC = 100 ;

                    intent.putExtra("requestCode", RC);

                    PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), RC, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                    assert alarmManager != null;
                    alarmManager.cancel(pendingIntent);

                    startService(intent);

                    //stopService(new Intent(getApplicationContext(), MyService.class));


                }
            }
        });

    }

    private void selctGovernrate() {

        governerates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int posi = (int) arrayAdapter.getItemId(i);
                String name = arrayAdapter.getItem(i).toString();

                if(name.equals("اختر محافظتك")){
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));
                }else {
                    SavegovernrateName(getApplicationContext(),"gover",name);

                }

                changeLocLayout.setVisibility(View.INVISIBLE);
                prayingTimeLayout.setVisibility(View.VISIBLE);

                if (posi==0){


                } else if (posi == 1) {

                    latitude = 30.04167;
                    longitude = 31.23528;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");

                    CaluclationMethod();

                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));


                } else if (posi == 2) {
                    latitude = 31.20194;
                    longitude = 29.91611;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();

                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 3) {

                    latitude = 31.26000;
                    longitude = 32.29000;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();

                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 4) {

                    latitude = 31.11167;
                    longitude = 30.94583;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();

                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 5) {

                    latitude = 30.56667;
                    longitude = 31.50000;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 6) {

                    latitude = 30.55861;
                    longitude = 31.01000;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 7) {

                    latitude = 28.24167;
                    longitude = 33.62222;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 8) {

                    latitude = 31.13194;
                    longitude = 33.80333;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 9) {

                    latitude = 31.35361;
                    longitude = 27.23722;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 10) {

                    latitude = 29.20278;
                    longitude = 25.51972;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 11) {

                    latitude = 27.17750;
                    longitude = 31.18583;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 12) {

                    latitude = 26.15444;
                    longitude = 32.71611;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                } else if (posi == 13) {

                    latitude = 24.08889;
                    longitude = 32.89972;

                    saveData(latitude, longitude);

                    txtPrayerTimes.setText("");
                    CaluclationMethod();
                    selectedGovernerate.setText("مَوَاقِيتُ الصَّلَاَة \n" + getgovernrateName(getApplicationContext()));

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void CaluclationMethod() {

        double timezone = (Calendar.getInstance().getTimeZone()
                .getOffset(Calendar.getInstance().getTimeInMillis()))
                / (1000 * 60 * 60);
        PrayTime prayers = new PrayTime();

        prayers.setTimeFormat(prayers.Time12);
        prayers.setCalcMethod(prayers.Egypt);
        prayers.setAsrJuristic(prayers.Shafii);
        prayers.setAdjustHighLats(prayers.AngleBased);
        int[] offsets = {0, 0, 0, 0, 0, 0, 0}; // {Fajr,Sunrise,Dhuhr,Asr,Sunset,Maghrib,Isha}
        prayers.tune(offsets);

        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        prayerTimes = prayers.getPrayerTimes(cal, latitude,
                longitude, timezone);
        ArrayList prayerNames = prayers.getTimeNames();

        for (int i = 0; i < prayerTimes.size(); i++) {
            txtPrayerTimes.append("\n" + prayerNames.get(i) + " :- "
                    + prayerTimes.get(i) + " \n ");

        }

        SavePrayinTimes(getApplicationContext(), "fajr", String.valueOf(prayerTimes.get(0)));
        SavePrayinTimes(getApplicationContext(), "zhr", String.valueOf(prayerTimes.get(2)));
        SavePrayinTimes(getApplicationContext(), "asr", String.valueOf(prayerTimes.get(3)));
        SavePrayinTimes(getApplicationContext(), "magrib", String.valueOf(prayerTimes.get(5)));
        SavePrayinTimes(getApplicationContext(), "isha", String.valueOf(prayerTimes.get(6)));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_header, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.loc) {

            if (state == 0) {

                changeLocLayout.setVisibility(View.VISIBLE);
                prayingTimeLayout.setVisibility(View.INVISIBLE);
                state = 1;
            } else {
                changeLocLayout.setVisibility(View.INVISIBLE);
                prayingTimeLayout.setVisibility(View.VISIBLE);
                state = 0;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    public void ShowPrayTimes(View view) {
        changeLocLayout.setVisibility(View.INVISIBLE);
        prayingTimeLayout.setVisibility(View.VISIBLE);
    }

    public void SetLongLati(View view) {

        try {

            latitude = Double.valueOf(LatidudeEdit.getText().toString());
            longitude = Double.valueOf(LogitudeEdit.getText().toString());

            saveData(latitude, longitude);

            txtPrayerTimes.setText("");
            CaluclationMethod();

            changeLocLayout.setVisibility(View.INVISIBLE);
            prayingTimeLayout.setVisibility(View.VISIBLE);

        } catch (Exception e) {

            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "من فضلك ادخل الارقام فى الفراغات كما فى المثال", Toast.LENGTH_LONG).show();
        }

    }

    public void CopyLoca(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("label", copyLoca.getText().toString());
        assert clipboardManager != null;
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(getApplicationContext(), "تم نسخ النص , إلصق النص فى اى متصفح", Toast.LENGTH_LONG).show();

    }

    public void saveData(double lati, double longi) {

        SharedPreferences sharedPreferences = getSharedPreferences(PRAYING_VALUES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("lati", String.valueOf(lati));
        editor.putString("longi", String.valueOf(longi));

        editor.apply();

    }

    public void getVales() {

        SharedPreferences sharedPreferences = getSharedPreferences(PRAYING_VALUES, MODE_PRIVATE);

        String here1 = sharedPreferences.getString("lati", "30.041802");
        String here2 = sharedPreferences.getString("longi", "31.234947");

        latitude = Double.parseDouble(here1);
        longitude = Double.parseDouble(here2);

    }

    public void saveState(String key, boolean value, Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();

    }

    public void getState(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean azanstate = sharedPreferences.getBoolean("azanButton", false);

        if (azanstate) {
            azan_button.setChecked(true);

        } else {
            azan_button.setChecked(false);
        }
    }

    private void SavePrayinTimes(Context context, String key, String time) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, time);
        editor.apply();

    }

    private void SavegovernrateName(Context context, String key, String name) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, name);
        editor.apply();

    }

    private String getgovernrateName(Context context) {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString("gover", "القاهرة");

    }

}
