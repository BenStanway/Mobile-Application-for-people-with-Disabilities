package com.example.myapplication.Carer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class carerMenu extends AppCompatActivity {

    Button view, patient, preferences, wellbeinglog;
    ImageButton logout;
    DBHelper dbHelper;
    int k = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_menu);

        dbHelper = new DBHelper(this);


        view = findViewById(R.id.patientInfoBtn);
        logout = findViewById(R.id.logout);
        preferences = findViewById(R.id.Preferences);
        preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carerMenu.this, Preferences.class);
                startActivity(intent);
            }
        });
        wellbeinglog = findViewById(R.id.WellBeingLog);
        wellbeinglog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carerMenu.this, WellBeing.class);
                startActivity(intent);
            }
        });

        patient = findViewById(R.id.PatientSearchBtn);
        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carerMenu.this, ShoppingList.class);
                startActivity(intent);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carerMenu.this, UsersInformation.class);
                startActivity(intent);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(carerMenu.this);
                builder.setTitle("Logout");
                builder.setMessage("Continue to logout ?");
                builder.setPositiveButton("Yes I'm sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(carerMenu.this, carerLogin.class);
                        startActivity(intent);
                        finish();
                    }
                });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    public void onBackPressed() {
        k++;
        if (k == 1) {
            Toast.makeText(carerMenu.this, "Press again to go previous activity.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(carerMenu.this, carerLogin.class);
            startActivity(intent);
        } else {
            finish();
        }
    }
}
