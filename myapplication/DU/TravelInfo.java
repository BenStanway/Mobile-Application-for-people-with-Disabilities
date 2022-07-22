package com.example.myapplication.DU;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class TravelInfo extends shake {

    ImageButton taxi, train, buspass, bluecard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_info);

        taxi=findViewById(R.id.taxiBtn);
        taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.gov.uk/guidance/rights-of-disabled-passengers-on-transport");
            }
        });

        train=findViewById(R.id.trainBtn);
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nationalrail.co.uk/stations_destinations/");
            }
        });

       buspass=findViewById(R.id.coachBtn);
        buspass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.gov.uk/apply-for-disabled-bus-pass");
            }
        });


        bluecard=findViewById(R.id.disabledBtn);
        bluecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.gov.uk/apply-blue-badge");
            }
        });


    }
    public void URL(String url){
        Uri uriUrl= Uri.parse(url);
        Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launch);
    }


}