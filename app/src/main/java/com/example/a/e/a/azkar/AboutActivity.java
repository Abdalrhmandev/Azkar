package com.example.a.e.a.azkar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends Azkar_Main {


    TextView tsome ,firstText,secondText;
    FrameLayout frameLayout;

    CardView cardViewconnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        frameLayout = (FrameLayout)findViewById(R.id.frame_content);
        getLayoutInflater().inflate(R.layout.activity_about,frameLayout);

        tsome = (TextView) findViewById(R.id.tsome);
        cardViewconnect = (CardView)findViewById(R.id.connectcard);

        firstText = (TextView)findViewById(R.id.firstText);
        secondText= (TextView)findViewById(R.id.secondText);


    }


    public void Transport(View view) {

        int id = view.getId();

        if (id == R.id.bsome){
            tsome.getParent().requestChildFocus(tsome,tsome);
        }

        else if (id == R.id.bconnect){
            cardViewconnect.getParent().requestChildFocus(cardViewconnect,cardViewconnect);
        }
    }

    public void textsOnclick(View view) {

        int id = view.getId();

        if (id==R.id.firstText){
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label",firstText.getText().toString());
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(getApplicationContext(),"تم نسخ Dev Email = إيميل المبرمج",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.secondText){
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("label",secondText.getText().toString());
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(getApplicationContext(),"تم نسخ App Email = إيميل التطبيق",Toast.LENGTH_LONG).show();
        }
        else if (id==R.id.rater){




        }

    }

}
