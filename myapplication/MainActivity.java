package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Carer.carerLogin;
import com.example.myapplication.DU.DuLogin;


public class MainActivity extends AppCompatActivity {

    Button btn, secondbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openListIntent = new Intent(MainActivity.this, DuLogin.class);
                startActivity(openListIntent);
            }
        });
        secondbtn=findViewById(R.id.button2);
        secondbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMap = new Intent(MainActivity.this, carerLogin.class);
                startActivity(openMap);

            }
        });

    }
}
