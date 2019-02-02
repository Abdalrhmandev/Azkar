package com.example.a.e.a.azkar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MosqueAzkarActivity extends AppCompatActivity {

    Toolbar toolbar;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    AzkaratAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mosque_azkar);

        toolbar = (Toolbar)findViewById(R.id.navi_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AzkaratAdapter(getApplicationContext(),getData());
        recyclerView.setAdapter(adapter);


    }

    public List getData (){

        String[] zikr = {
                "دُعَاءُ الذَّهَابِ إلَى المَسْجِدِ\n" +
                        "اللّهُـمَّ اجْعَـلْ في قَلْبـي نورا ، وَفي لِسـاني نورا، وَاجْعَـلْ في سَمْعي نورا، وَاجْعَـلْ في بَصَري نورا، وَاجْعَـلْ مِنْ خَلْفي نورا، وَمِنْ أَمامـي نورا، وَاجْعَـلْ مِنْ فَوْقـي نورا ، وَمِن تَحْتـي نورا .اللّهُـمَّ أَعْطِنـي نورا",
                "دُعَاءُ دُخُولِ المَسْجِدِ\n" +
                        "يَبْدَأُ بِرِجْلِهِ اليُمْنَى، وَيَقُولُ:\n" +
                        "أَعوذُ باللهِ العَظيـم وَبِوَجْهِـهِ الكَرِيـم وَسُلْطـانِه القَديـم مِنَ الشّيْـطانِ الرَّجـيم، بِسْمِ اللَّهِ، وَالصَّلاةُ وَالسَّلامُ عَلَى رَسُولِ الله، اللّهُـمَّ افْتَـحْ لي أَبْوابَ رَحْمَتـِك",
                "دُعَاءُ الخُرُوجِ مِنَ المَسْجِدِ\n" +
                        "يَبْدَأُ بِرِجْلِهِ الْيُسْرَى، وَيَقُولُ:\n" +
                        "بِسْـمِ اللَّـهِ وَالصَّلاةُ وَالسَّلامُ عَلَى رَسُولِ اللَّهِ، اللَّهُمَّ إنِّي أَسْأَلُكَ مِنْ فَضْلِكَ، اللَّهُمَّ اعْصِمْنِي مِنَ الشَّيْطَانِ الرَّجِيم"


        };

        String[] fadl = {
                "فضل الذكر : من أذكار المسجد",
                "فضل الذكر : من أذكار المسجد",
                "فضل الذكر : من أذكار المسجد"
        };

        String[] repeat = {
                "عدد التكرار : 1",
                "عدد التكرار : 1",
                "عدد التكرار : 1"

        };



        List<AzkarInformation> data = new ArrayList<>();

        for (int i = 0;i<fadl.length&&i<zikr.length&&i<repeat.length;i++){

            AzkarInformation current = new AzkarInformation();

            current.fadl = fadl[i];
            current.repeat=repeat[i];
            current.zikr = zikr[i];

            data.add(current);

        }

        return data;
    }


}
