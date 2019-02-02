package com.example.a.e.a.azkar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class WalkupAzkarActivity extends AppCompatActivity {


    Toolbar toolbar;
    AzkaratAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkup_azkar);

        toolbar = (Toolbar)findViewById(R.id.navi_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AzkaratAdapter(getApplicationContext(),getData());
        recyclerView.setAdapter(adapter);


    }

    public List getData(){

        String[] zikr = {
                "الحَمْـدُ لِلّهِ الّذي أَحْـيانا بَعْـدَ ما أَماتَـنا وَإليه النُّـشور.",
                "الحمدُ للهِ الذي عافاني في جَسَدي وَرَدّ عَليّ روحي وَأَذِنَ لي بِذِكْرِه.",
                "لا إلهَ إلاّ اللّهُ وَحْـدَهُ لا شَـريكَ له، لهُ المُلـكُ ولهُ الحَمـد، وهوَ على كلّ شيءٍ قدير، سُـبْحانَ اللهِ، والحمْـدُ لله ، ولا إلهَ إلاّ اللهُ واللهُ أكبَر، وَلا حَولَ وَلا قوّة إلاّ باللّهِ العليّ العظيم. رَبِّ اغْفرْ لي.",

        };
        String[] fadl = {
                "فضل الذكر : من اذكار الاستيقاظ",
                "فضل الذكر : من اذكار الاستيقاظ",
                "فضل الذكر : من اذكار الاستيقاظ",

        };
        String[] repeat = {
                "عدد التكرار : 1",
                "عدد التكرار : 1",
                "عدد التكرار : 1",
        };






        List<AzkarInformation> data = new ArrayList<>();
        for (int i = 0 ; i<zikr.length&&i<fadl.length;i++){
            AzkarInformation current = new AzkarInformation();
            current.zikr=zikr[i];
            current.fadl = fadl[i];
            current.repeat = repeat[i];
            data.add(current);
        }

        return data;
    }
}
