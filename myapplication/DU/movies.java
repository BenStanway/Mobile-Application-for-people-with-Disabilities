package com.example.myapplication.DU;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class movies extends shake {

    ImageButton netfilx, prime, youtube, disney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        netfilx=findViewById(R.id.netflixBtn);
        netfilx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.netflix.com/gb/");
            }
        });

        prime=findViewById(R.id.primeBtn);
        prime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               URL(" https://www.amazon.co.uk/Amazon-Video/b?ie=UTF8&node=3010085031");
            }
        });

        youtube=findViewById(R.id.youtubeBtn);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.youtube.com/");
            }
        });

        disney=findViewById(R.id.disneyBtn);
        disney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL("https://www.disneyplus.com/en-gb/");
            }
        });


    }
    private void URL(String url){
        Uri uriUrl= Uri.parse(url);
        Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launch);
    }
}