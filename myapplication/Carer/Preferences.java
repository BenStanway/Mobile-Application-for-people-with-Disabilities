package com.example.myapplication.Carer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;

public class Preferences extends AppCompatActivity {

    EditText PREF_ITEM1, PREF_ITEM2, PREF_ITEM3, PREF_ITEM4, PREF_ITEM5,
            PREF_ITEM6, PREF_ITEM7, PREF_ITEM8, PREF_ITEM9, PREF_ITEM10;
    DBHelper dbHelper;
    Button savePref, viewpref, updatePref, deletePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);


        PREF_ITEM1 = findViewById(R.id.PREF_ITEM1);
        PREF_ITEM2 = findViewById(R.id.PREF_ITEM2);
        PREF_ITEM3 = findViewById(R.id.PREF_ITEM3);
        PREF_ITEM4 = findViewById(R.id.PREF_ITEM4);
        PREF_ITEM5 = findViewById(R.id.PREF_ITEM5);
        PREF_ITEM6 = findViewById(R.id.PREF_ITEM6);
        PREF_ITEM7 = findViewById(R.id.PREF_ITEM7);
        PREF_ITEM8 = findViewById(R.id.PREF_ITEM8);
        PREF_ITEM9 = findViewById(R.id.PREF_ITEM9);
        PREF_ITEM10 = findViewById(R.id.PREF_ITEM10);


        updatePref = findViewById(R.id.updatePatientPreferences);
        deletePref = findViewById(R.id.deletePatientPreferences);



        savePref = findViewById(R.id.savePref);
        savePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PREF_ITEM1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please add Something onto the preferences", Toast.LENGTH_LONG).show();
                } else {
                    dbHelper.addPref(PREF_ITEM1.getText().toString(), PREF_ITEM2.getText().toString(),
                            PREF_ITEM3.getText().toString(), PREF_ITEM4.getText().toString(),
                            PREF_ITEM5.getText().toString(), PREF_ITEM6.getText().toString(), PREF_ITEM7.getText().toString(),
                            PREF_ITEM8.getText().toString(), PREF_ITEM9.getText().toString(), PREF_ITEM10.getText().toString());
                    Toast.makeText(getApplicationContext(), "Preference Items entered", Toast.LENGTH_LONG).show();
                }
            }
        });
        dbHelper = new DBHelper(this);
        updatePrefData();
        viewpref = findViewById(R.id.viewPref);
        viewpref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientPref.class);
                startActivity(intent);
            }
        });

        deletePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkDeleteData = dbHelper.deletePreferences(PREF_ITEM1.getText().toString(), PREF_ITEM2.getText().toString(),
                        PREF_ITEM3.getText().toString(), PREF_ITEM4.getText().toString(),
                        PREF_ITEM5.getText().toString(), PREF_ITEM6.getText().toString(), PREF_ITEM7.getText().toString(),
                        PREF_ITEM8.getText().toString(), PREF_ITEM9.getText().toString(), PREF_ITEM10.getText().toString());

                if (checkDeleteData == true) {
                    Toast.makeText(Preferences.this, "Preferences Deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(Preferences.this, "Preferences Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void updatePrefData(){
        updatePref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated = dbHelper.updatePref(PREF_ITEM1.getText().toString(), PREF_ITEM2.getText().toString(),
                        PREF_ITEM3.getText().toString(), PREF_ITEM4.getText().toString(),
                        PREF_ITEM5.getText().toString(), PREF_ITEM6.getText().toString(), PREF_ITEM7.getText().toString(),
                        PREF_ITEM8.getText().toString(), PREF_ITEM9.getText().toString(), PREF_ITEM10.getText().toString());

                if (isupdated == true) {
                    Toast.makeText(getApplicationContext(), "Preferences Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Preferences Not Updated", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}

