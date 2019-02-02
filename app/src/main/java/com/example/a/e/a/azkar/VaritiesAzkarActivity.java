package com.example.a.e.a.azkar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class VaritiesAzkarActivity extends AppCompatActivity {

    Toolbar toolbar;
    AzkaratAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varities_azkar);

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
                "أذكار من قلق في فراشه ولم ينم\n\n" +
                        "عن بريدة رضي الله عنه، قال\u200F:\u200F شكا خالد بن الوليد رضي الله عنه إلى النبي صلى الله عليه وسلم فقال\u200F:\u200F يا رسول الله\u200F!\u200F ما أنام الليل من الأرق، فقال النبي صلى الله عليه وسلم\u200F:\u200F \u200F\"\u200Fإذا أويت إلى فراشك فقل\u200F:\u200F اللهم رب السموات السبع وما أظلت، ورب الأرضين وما أقلت، ورب الشياطين وما أضلت، كن لي جارا من خلقك كلهم جميعا أن يفرط علي أحد منهم أو أن يبغي علي، عز جارك، وجل ثناؤك ولا إله غيرك، ولا إله إلا أنت\u200F\"\n" +
                        "\n" +
                        "عن عمرو بن شعيب، عن أبيه، عن جده: أن رسول الله صلى الله عليه وسلم كان يعلمهم من الفزع كلمات\u200F:\u200F \u200F\"\u200Fأعوذ بكلمات الله التامة من غضبه وشر عباده، ومن همزات الشياطين وأن يحضرون\u200F\"" +
                        "",
                        "أذكار الأحلام\n" +
                        "عن أبي قتادة رضي الله عنه قال\u200F:\u200F قال رسول الله صلى الله عليه وسلم\u200F:\u200F \u200F\"\u200Fالرؤيا الصالحة\u200F\"\u200F وفي رواية \u200F\"\u200Fالرؤيا الحسنة من الله، والحلم من الشيطان، فمن رأى شيئا يكرهه فلينفث عن شماله ثلاثا وليتعوذ من الشيطان، فإنها لا تضره\u200F\"." +
                        "",
                "أذكار الدخول إلى المنزل\n" +
                        "بِسْـمِ اللهِ وَلَجْنـا، وَبِسْـمِ اللهِ خَـرَجْنـا، وَعَلـى رَبِّنـا تَوَكّلْـنا.",
                "أذكار الخروج من المنزل\n" +
                        "بِسْمِ اللهِ ، تَوَكَّلْـتُ عَلى اللهِ وَلا حَوْلَ وَلا قُـوَّةَ إِلاّ بِالله.\n" +
                        "اللّهُـمَّ إِنِّـي أَعـوذُ بِكَ أَنْ أَضِـلَّ أَوْ أُضَـل ، أَوْ أَزِلَّ أَوْ أُزَل ، أَوْ أَظْلِـمَ أَوْ أَُظْلَـم ، أَوْ أَجْهَلَ أَوْ يُـجْهَلَ عَلَـيّ. "

        };

        String[] fadl = {
                "أذكار من قلق في فراشه ولم ينم",
                "أذكار الأحلام",
                "أذكار الدخول إلى المنزل",
                "أذكار الخروج من المنزل",

        };

        String[] repeat = {
                "عدد التكرار : 1",
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
