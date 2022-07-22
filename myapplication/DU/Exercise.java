package com.example.myapplication.DU;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class Exercise extends shake {

    Button ActivitiesBtn, DancingBtn, WheelchairBtn, WebsiteBtn, NHS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        ActivitiesBtn = findViewById(R.id.ActivitiesBtn);
        ActivitiesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://parasport.org.uk/?gclid=Cj0KCQjwse-DBhC7ARIsAI8YcWKRt9S2hLID80kYBwu-fenX0L026jPTf-c6loKgIUE4z4xtDow4SPIaAqpeEALw_wcB");
            }
        });
        DancingBtn = findViewById(R.id.DancingBtn);
        DancingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.youtube.com/channel/UCnlTby2BI0Oz2kddSXDH66Q");
            }
        });
        WheelchairBtn = findViewById(R.id.WheelchairBtn);
        WheelchairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.youtube.com/watch?v=X6TtFr2Zp_s");
            }
        });
        WebsiteBtn = findViewById(R.id.ifiBtn);
        WebsiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("http://www.activityalliance.org.uk/get-active/inclusive-gyms?utf8=%E2%9C%93&loc=");
            }
        });

        NHS = findViewById(R.id.NHS);
        NHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.nhs.uk/live-well/exercise/get-active-with-a-disability/?tabname=fitness-guides");
            }
        });

    }

    private void URL(String url){
        Uri uriUrl= Uri.parse(url);
        Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launch);
    }


}