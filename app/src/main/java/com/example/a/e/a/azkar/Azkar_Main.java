package com.example.a.e.a.azkar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.util.Random;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;
public class Azkar_Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SELECTED_ITEM_ID = "selectedId";
    private static final String FIRST_TIME = "firstTime";
    private static final String FILE_START = "startfile";

    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    //boolean userSawdrawer = false;
    int selectedItemId;

    FloatingActionButton actionButton;
    SubActionButton floatebutton1, floatebutton2;
    ImageView floateone, floatetwo;
    TextView fadlTextView;
    CoordinatorLayout coordinatorLayout;

    FloatingActionMenu floatingActionMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar__main);

        toolbar = findViewById(R.id.navi_bar);

        navigationView = findViewById(R.id.navigation_view);

        drawerLayout = findViewById(R.id.drawer_layout);

        selectedItemId = savedInstanceState == null ? R.id.main_menu : savedInstanceState.getInt(SELECTED_ITEM_ID);

        /*if(!didUserSawDrawer()){
            drawerLayout.openDrawer(GravityCompat.START);
            userSawDrawer();
        }
        else {
            drawerLayout.closeDrawer(GravityCompat.START);
        }*/

        actionButton = findViewById(R.id.fab);
        fadlTextView = findViewById(R.id.fadltextView);
        coordinatorLayout = findViewById(R.id.coLayout);


        getstart();

    }


    @Override
    protected void onStart() {

        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.opne, R.string.close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();


        floateone = new ImageView(this);
        floateone.setImageResource(R.mipmap.s1fbutton);
        floatetwo = new ImageView(this);
        floatetwo.setImageResource(R.mipmap.s2fbutton);

        SubActionButton.Builder builder = new SubActionButton.Builder(this);
        builder.setBackgroundDrawable(getResources().getDrawable(R.drawable.subfloatecolor));


        floatebutton1 = builder.setContentView(floateone)
                .build();

        floatebutton2 = builder.setContentView(floatetwo).build();


        floatingActionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(floatebutton1)
                .addSubActionView(floatebutton2)
                .attachTo(actionButton)
                .build();

        floatebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtextPrepare();
                floatingActionMenu.close(true);
            }
        });

        floatebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FadlTextPrepare();
                floatingActionMenu.close(true);
            }
        });


        super.onStart();
    }


    public void prompet() {


        new MaterialTapTargetPrompt.Builder(Azkar_Main.this)
                .setTarget(findViewById(R.id.fab))
                .setPrimaryText("زر الرئيسى")
                .setSecondaryText("تصميمه مميز و فريد من نوعه \n يحتوى على اثنين \n احدهما لعرض فضل الاذكر باسلوب مميز \n التانى معلومات و سنن مهجورة للرسول و بعض مواقف الصحابه")
                .setBackgroundColour(getResources().getColor(R.color.pink1))
                .setFocalColour(getResources().getColor(R.color.green1))
                //.setAutoDismiss(false)
                .setBackButtonDismissEnabled(true)
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                    @Override
                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                        if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED) {

                            new MaterialTapTargetPrompt.Builder(Azkar_Main.this)
                                    .setTarget(toolbar.getChildAt(1))
                                    .setPrimaryText("القائمة الرئيسية")
                                    .setSecondaryText("اسلوب جديد فى عرض القائمة الرئيسية \n تحتوى على الاذكارات و التنبيهات وكل ما تحتاجه فى هذا التطبيق ^_^")
                                    .setBackgroundColour(getResources().getColor(R.color.pink1))
                                    .setFocalColour(getResources().getColor(R.color.green1))
                                    .setAutoDismiss(false)
                                    .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                        @Override
                                        public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                            if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED) {
                                                floatingActionMenu.close(true);
                                            }
                                        }
                                    })
                                    .show();
                        }
                    }
                })
                .show();

        savestart("aaa", true);


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        item.setChecked(true);
        selectedItemId = item.getItemId();
        Intent intent = null;
        String title = item.getTitle().toString();

        if (selectedItemId == R.id.main_menu) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Azkar_Main.class);
            startActivity(intent);
            setTitle(title);
            return true;
        }

        if (selectedItemId == R.id.azkarat_menu) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, AzkaratActivity.class);
            startActivity(intent);

            return true;
        }


        if (selectedItemId == R.id.counter_menu) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, Counter.class);
            startActivity(intent);

            return true;
        }

        if (selectedItemId == R.id.praying_times) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, PrayingTimes.class);
            startActivity(intent);

            return true;
        }

        if (selectedItemId == R.id.textnoti) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, TextNoti_Activity.class);
            startActivity(intent);
            return true;
        }

        if (selectedItemId == R.id.voicenoti) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, VoiceNotiActivity.class);
            startActivity(intent);
            return true;
        }
        if (selectedItemId == R.id.share_menu) {
            intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "تطبيق أذكار = Azkar ");
            intent.putExtra(Intent.EXTRA_TEXT, " تطبيق اذكار المميز , يحتوى التطبيق على اسلوب جديد فى التذكير الشخص بالاذكارات سواء كانت الصوتيه او المكتوبه \n\n و التصميم الفريد من نوعه و باستخدام احدث الخصائص المتوفره للاندرويد \n\n و ايضا ابسلوبه الرائع فى جذبك الى داخل التطبيق مره اخرى \n\n  والاهم انه مجانى يعتبر صدقه جاريه وليس به اى مصدر للربح مما يعنى انك لك اجر من من يستخدمه و فهو بعتبر صدقه جاريه لك و مصدر غير محدود للحسنات لك فى حاله اذا استخدمه شخص اخر عن  طريقك \n" +
                    "\n اليك رابط التطبيق \n" +
                    "\n\n" +
                    "\n https://play.google.com/store/apps/details/?id=com.example.a.e.a.azkar     ");
            intent.createChooser(intent, "اختار التطبيق المناسب لك ^_*");
            startActivity(intent);
        }
        if (selectedItemId == R.id.about_menu) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        if (selectedItemId == R.id.idea) {
            drawerLayout.closeDrawer(GravityCompat.START);
            intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.setType("message/rfc822");
            String email = "azkarappaea@gmail.com";
            intent.putExtra(Intent.EXTRA_EMAIL, email);
            intent.putExtra(Intent.EXTRA_SUBJECT, "هذا رايك او اقتراحك او الاثنان ؟ ^_^");
            intent.putExtra(Intent.EXTRA_TEXT, "");

            Intent chooser = Intent.createChooser(intent, "اختار التطبيق المناسب لك ^_^ ");
            startActivity(chooser);

        }

        if (selectedItemId == R.id.closeapp) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory(Intent.CATEGORY_HOME);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            android.os.Process.killProcess(android.os.Process.myPid());
            finish();
            System.exit(2);
            return true;
        }


        return false;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM_ID, selectedItemId);
    }


   /* public boolean didUserSawDrawer (){

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        userSawdrawer = sharedPref.getBoolean(FIRST_TIME , false);
        return userSawdrawer;

    }

    public void userSawDrawer (){

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        userSawdrawer = true;
        sharedPref.edit().putBoolean(FIRST_TIME,userSawdrawer).apply();
    }*/


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();

        }
    }


    public void FadlTextPrepare() {

        Animation a = AnimationUtils.loadAnimation(this, R.anim.fadltextanim);
        a.reset();
        fadlTextView.clearAnimation();
        fadlTextView.startAnimation(a);

        String[] floatarray = getResources().getStringArray(R.array.floatingFadl);
        Random r = new Random();
        String fadl = floatarray[r.nextInt(floatarray.length)];
        fadlTextView.setText(fadl);
    }

    public void subtextPrepare() {

        String[] texts = getResources().getStringArray(R.array.floatingText);
        Random r = new Random();
        String one = texts[r.nextInt(texts.length)];
        Snackbar snackbar = Snackbar.make(coordinatorLayout, one, Snackbar.LENGTH_INDEFINITE)
                .setAction(" تم ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });

        View snackBarView = snackbar.getView();
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setMaxLines(9);
        snackbar.show();

    }

    public void savestart(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_START, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void getstart() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_START, MODE_PRIVATE);
        boolean result = sharedPreferences.getBoolean("aaa", false);
        if (result == false) {
            prompet();
        } else {

        }
    }


}
