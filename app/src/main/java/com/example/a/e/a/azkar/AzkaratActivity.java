package com.example.a.e.a.azkar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class AzkaratActivity extends Azkar_Main {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame_content);
        getLayoutInflater().inflate(R.layout.activity_azkarat,frameLayout);

    }


    public void Move(View view) {

       int id = view.getId();
        Intent intent = null;

        if (id == R.id.morning){
            intent = new Intent(this,MorningAzkarActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.night){
            intent = new Intent(this,NightAzkarActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.mosque){
            intent = new Intent(this,MosqueAzkarActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.pray){
            intent = new Intent(this,PrayAzkarActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.sleep){
            intent = new Intent(this,SleepAzkarActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.walkup){
            intent = new Intent(this,WalkupAzkarActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.varities){
            intent = new Intent(this,VaritiesAzkarActivity.class);
            startActivity(intent);
        }

    }
}
