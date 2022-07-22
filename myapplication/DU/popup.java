package com.example.myapplication.DU;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

public class popup extends Activity {

    ImageButton contactbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);



        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        contactbtn = findViewById(R.id.imageButton2);
        contactbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(popup.this, otherpop.class));
//                        Intent callIntent = new Intent(Intent.ACTION_CALL);
//                        callIntent.setData(Uri.parse("tel:07985712464"));
//                        startActivity(callIntent);



            }
        });

                int width = dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int) (height*.6));

    }

}