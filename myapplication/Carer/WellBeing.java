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

public class WellBeing extends AppCompatActivity {

    EditText LOG_Note1, LOG_Note2, LOG_Note3, LOG_Note4, LOG_Note5,
            LOG_Note6, LOG_Note7, LOG_Note8, LOG_Note9, LOG_Note10;
    Button saveLog, viewLog, updateLog, deleteLog;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_well_being);

        LOG_Note1 = findViewById(R.id.LOG_ITEM1);
        LOG_Note2 = findViewById(R.id.LOG_ITEM2);
        LOG_Note3 = findViewById(R.id.LOG_ITEM3);
        LOG_Note4 = findViewById(R.id.LOG_ITEM4);
        LOG_Note5 = findViewById(R.id.LOG_ITEM5);
        LOG_Note6 = findViewById(R.id.LOG_ITEM6);
        LOG_Note7 = findViewById(R.id.LOG_ITEM7);
        LOG_Note8 = findViewById(R.id.LOG_ITEM8);
        LOG_Note9 = findViewById(R.id.LOG_ITEM9);
        LOG_Note10 = findViewById(R.id.LOG_ITEM10);
        updateLog = findViewById(R.id.updateLog);
        deleteLog = findViewById(R.id.deleteLog);
        saveLog = findViewById(R.id.saveLog);
        viewLog = findViewById(R.id.viewLog);
        updateLog();
        dbHelper = new DBHelper(this);

        deleteLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkDeleteData = dbHelper.deleteLog(LOG_Note1.getText().toString(), LOG_Note2.getText().toString(),
                        LOG_Note3.getText().toString(), LOG_Note4.getText().toString(),
                        LOG_Note5.getText().toString(), LOG_Note6.getText().toString(), LOG_Note7.getText().toString(),
                        LOG_Note8.getText().toString(), LOG_Note9.getText().toString(), LOG_Note10.getText().toString());

                if (checkDeleteData == true) {
                    Toast.makeText(WellBeing.this, "Wellbeing Log Deleted", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(WellBeing.this, "Wellbeing Log Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });


        saveLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LOG_Note1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter something to the wellbeing log", Toast.LENGTH_LONG).show();
                } else {
                    dbHelper.addLog(LOG_Note1.getText().toString(), LOG_Note2.getText().toString(),
                            LOG_Note3.getText().toString(), LOG_Note4.getText().toString(),
                            LOG_Note5.getText().toString(), LOG_Note6.getText().toString(), LOG_Note7.getText().toString(),
                            LOG_Note8.getText().toString(), LOG_Note9.getText().toString(), LOG_Note10.getText().toString());
                    Toast.makeText(getApplicationContext(), "Wellbeing Log Entered", Toast.LENGTH_LONG).show();
                }
            }
        });

        viewLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), logList.class);
                startActivity(intent);
            }
        });

    }

    public void updateLog() {
        updateLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated = dbHelper.updateLog(LOG_Note1.getText().toString(), LOG_Note2.getText().toString(),
                        LOG_Note3.getText().toString(), LOG_Note4.getText().toString(),
                        LOG_Note5.getText().toString(), LOG_Note6.getText().toString(), LOG_Note7.getText().toString(),
                        LOG_Note8.getText().toString(), LOG_Note9.getText().toString(), LOG_Note10.getText().toString());

                if (isupdated == true) {
                    Toast.makeText(getApplicationContext(), "WellBeing Log Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "WellBeing Log Not Updated", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}


