package com.example.myapplication.DU;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.R;

public class Communication extends shake {

    ImageButton sadButton, happyButton, angryButton, scaredButton, hungryButton, tiredButton, illButton, boredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        MediaPlayer Communication = MediaPlayer.create(this, R.raw.menucommunication);
        Communication.start();

        MediaPlayer Sad = MediaPlayer.create(this, R.raw.feelingsad);
        sadButton = findViewById(R.id.trainBtn);
        sadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sad.start();
                Toast.makeText(Communication.this, "Sad", Toast.LENGTH_SHORT).show();
            }
        });

        MediaPlayer Happy = MediaPlayer.create(this, R.raw.feelinghappy);
        happyButton = findViewById(R.id.taxiBtn);
        happyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Happy.start();
                Toast.makeText(Communication.this, "Happy", Toast.LENGTH_SHORT).show();
            }
        });

        MediaPlayer angry = MediaPlayer.create(this, R.raw.feelingfurstrated);
        angryButton = findViewById(R.id.opticianBtn);
        angryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angry.start();
                Toast.makeText(Communication.this, "Angry", Toast.LENGTH_SHORT).show();

            }
        });

        MediaPlayer hungry = MediaPlayer.create(this, R.raw.feelinghungry);
        hungryButton = findViewById(R.id.pharmacyBtn);
        hungryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hungry.start();
                Toast.makeText(Communication.this, "Hungry", Toast.LENGTH_SHORT).show();
            }

        });

        MediaPlayer tired = MediaPlayer.create(this, R.raw.feelingtired);
        tiredButton = findViewById(R.id.ambulanceBtn);
        tiredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tired.start();
                Toast.makeText(Communication.this, "Tired", Toast.LENGTH_SHORT).show();
            }
        });

        MediaPlayer scared = MediaPlayer.create(this, R.raw.feelingscared);
        scaredButton = findViewById(R.id.hospitalBtn);
        scaredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scared.start();
                Toast.makeText(Communication.this, "Scared", Toast.LENGTH_SHORT).show();
            }
        });

        MediaPlayer bored = MediaPlayer.create(this, R.raw.feelingbored);
        boredButton = findViewById(R.id.mentalHealthBtn);
        boredButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bored.start();
                Toast.makeText(Communication.this, "Bored", Toast.LENGTH_SHORT).show();
            }
        });

        MediaPlayer ill = MediaPlayer.create(this, R.raw.feelingill);
        illButton = findViewById(R.id.sexualHealthBtn);
        illButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ill.start();
                Toast.makeText(Communication.this, "Ill", Toast.LENGTH_SHORT).show();
            }
        });

    }
}