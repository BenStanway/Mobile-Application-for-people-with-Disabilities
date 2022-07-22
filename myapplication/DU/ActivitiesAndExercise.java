package com.example.myapplication.DU;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class ActivitiesAndExercise extends shake {

    ImageButton sportsBtn, artsBtn, moviesBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities_and_exercise);

        MediaPlayer Activities = MediaPlayer.create(this, R.raw.menuactivities);
        Activities.start();

        sportsBtn=findViewById(R.id.sportsImage);
        sportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesAndExercise.this, Exercise.class);
                startActivity(intent);
            }
        });
        artsBtn=findViewById(R.id.artsImage);
        artsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesAndExercise.this, Arts.class);
                startActivity(intent);
            }
        });
        moviesBtn=findViewById(R.id.moviesImage);
        moviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitiesAndExercise.this, movies.class);
                startActivity(intent);
            }
        });




    }

    public void URL(String url){
        Uri uriUrl= Uri.parse(url);
        Intent launch = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launch);
    }

}