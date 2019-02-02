package com.example.a.e.a.azkar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Main_Splash extends AppCompatActivity {

    public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;

    ImageView logoImageView;
    TextView starttext1,starttext2,starttext3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__splash);

        logoImageView =  findViewById(R.id.img_logo);
        starttext1 = findViewById(R.id.starttext1);
        starttext2 = findViewById(R.id.starttext2);
        starttext3 = findViewById(R.id.starttext3);

        Random r = new Random();


        int[] images = {R.mipmap.img_face,R.mipmap.img_face2,R.mipmap.img_face1};
        int image = images[r.nextInt(images.length)];
        logoImageView.setImageResource(image);

        String[] first = {" السّلَامُ عَلَيكُمْ, هَلْ صَلَّيْتِ عَلَى النبى الْيَوْمَ !",
                " السّلَامُ عَلَيكُمْ, صِلٌّ عَلَى مُحَمَّدُ",
                " السّلَامُ عَلَيكُمْ, أَذُكِرَ اللَّهُ ",
                " السّلَامُ عَلَيكُمْ, هَلْ صُلِّيَتْ الْفُرُوضُ الخمسه الْيَوْمَ !",
                " السّلَامُ عَلَيكُمْ, صِلٌّ عَلَى مِنْ بَكَى شَوْقَا لِرُؤْيَتِنَا"
                ," السّلَامُ عَلَيكُمْ, صِلٌّ عَلَى مِنْ يُنَادَى يَوْمُ القيامه أَمَتَى أَمَتَى "};
        String firsttext = first[r.nextInt(first.length)];
        starttext1.setText(firsttext);

        String[] second = {"إِنَّ الْعُلَمَاءَ وَرَثَةُ الانْبِيَاءِ وَذَاكَ أَنَّ الانْبِيَاءَ لَمْ يُورِثُوا دِرْهَماً وَلا دِينَاراً .",
                " قَالٌ: قَالَ رَسُولُ اللَّهِ صَلَّى اللَّهُ عَلَيهِ وَسُلَّمَ:« إذاَ مَاتَ الْإِنْسَانُ اِنْقَطَعَ عَنهُ عَمَلهُ إلّا مِنْ ثَلَاثَةٍ: إلّا مِنْ صدقةِ جَارِيَّةٍ، أَوْ عَلْمَ يَنْتَفِعُ بِهِ، أَوْ وُلِّدَ صَالِحُ يَدْعُو لَهُ »",
                " قَالٌ: قَالَ رَسُولُ اللَّهِ صَلَّى اللَّهُ عَلَيهِ وَسُلَّمَ:« سُلُوَّا اللَّهِ عِلْمَا نَافِعًا، وَتُعَوِّذُوا بِاللَّهِ مِنْ عَلْمٍ لَا يَنْفَعُ » ",
                " قَالَ رَسُولُ اللَّهِ صَلَّى اللَّهُ عَلَيهِ وَسُلَّمَ يُقَوِّلُ: كُلَّ إمرئٍ فِي ظَلَّ صدقتُهُ حَتَّى يُفَصَّلْ بَيْنُ النَّاسِ- أَوْ قَالٌ: يَحْكُمُ بَيَّنَ النَّاسُ.",
                " قَالَ رَسُولُ اللَّهِ صَلَّى اللَّهُ عَلَيهِ وَسَلَّمَ: إِنْ الصدقه لتطفىء عَنْ أهْلِهَا حَرِّ الْقُبُورِ، وَإِنَّمَا يَسْتَظِلَّ الْمُؤْمِنُ يَوْمَ القيامه فى ظَلَّ صدقتُهُ.",
                " قَالَ سَيِّدُنَا عُمَرِ اِبْنِ الْخُطَّابِ رَضِىَ اللَّه عَنهُ:- حَاسَبُوا اِنْفَسْكُمْ قَبْلَ ان تُحَاسِبُوا, وَزَنُّوا اعمالكم قَبْلَ ان تُوَزِّنَ عَلَيكُمْ, وَاِعْلَمُوا ان مَلَك الْمَوْتِ قَدْ تَخَطَّاكُمْ الى غَيْركُمْ و سَيُتَخَطَّى غَيْرُكُمْ إِلَيكُمْ, فَخَذُّوا حَذَركُمْ. ",
                " الْكَيِّسُ مِنْ دَانَ نَفْسهُ, وَعَمَل لَمَّا بَعْدَ الْمَوْتِ, و الْعَاجِزَ مِنَ اِتَّبَعَ نَفْسهُ هَوَاهَا و تَمَنَّى عَلَى اللَّه"};
        String secondtext = second[r.nextInt(second.length)];
        starttext2.setText(secondtext);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        boolean animationStarted = false;
        if (!hasFocus || animationStarted) {
            return;
        }

        animate();

        super.onWindowFocusChanged(hasFocus);


    }

    private void animate() {

        ViewGroup container = (ViewGroup) findViewById(R.id.container);

        ViewCompat.animate(logoImageView)
                .translationY(-250)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION).setInterpolator(
                new DecelerateInterpolator(1.2f)).start();

        for (int i = 0; i < container.getChildCount(); i++) {
            View v = container.getChildAt(i);
            ViewPropertyAnimatorCompat viewAnimator;

            if (!(v instanceof Button)) {
                viewAnimator = ViewCompat.animate(v)
                        .translationY(50).alpha(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(1000);
            } else {
                viewAnimator = ViewCompat.animate(v)
                        .scaleY(1).scaleX(1)
                        .setStartDelay((ITEM_DELAY * i) + 500)
                        .setDuration(500);
            }

            viewAnimator.setInterpolator(new DecelerateInterpolator()).start();
        }
    }

    public void onclick(View view) {

        Intent intent = new Intent(Main_Splash.this,Azkar_Main.class);
        startActivity(intent);
        finish();

    }

}
