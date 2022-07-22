package com.example.myapplication.DU;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class Support extends shake {

    ImageButton nhs, supporttravel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        MediaPlayer Support = MediaPlayer.create(this, R.raw.menusupport);
        Support.start();

        nhs= findViewById(R.id.nhsButton);
        nhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nhsPageIntent = new Intent(Support.this, NhsInfo.class);
                startActivity(nhsPageIntent);
            }
        });

        supporttravel=findViewById(R.id.supporttransport);
        supporttravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent travelPageIntent = new Intent(Support.this, TravelInfo.class);
                startActivity(travelPageIntent);
            }
        });
    }
}