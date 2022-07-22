package com.example.myapplication.Carer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;

public class UsersInformation extends AppCompatActivity {

    DBHelper dbHelper;
    TextView show1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_information);

        dbHelper = new DBHelper(this);


        SQLiteDatabase simpledb=getApplicationContext().openOrCreateDatabase("signin.db", Context.MODE_PRIVATE, null);
        Cursor c = simpledb.rawQuery("select * from duusers", null);
        if(c.getCount()==0) {
            //if nothing is found
            Toast.makeText(getApplicationContext()," nothing found", Toast.LENGTH_LONG).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){
            buffer.append("ID: "+ c.getString(0) + "\n");
            buffer.append("FullName : "+ c.getString(1) + "\n");
            buffer.append("Email : "+ c.getString(2) + "\n");
            buffer.append("Password : "+ c.getString(3) + "\n");
            buffer.append("PhoneNumber : "+ c.getString(5) + "\n");
            buffer.append("EmergencyPhoneNumber: "+ c.getString(6) + "\n");
            buffer.append("\n");
        }

        show1 = findViewById(R.id.showInfo1);

            show1.setText(buffer.toString());
            Toast.makeText(UsersInformation.this, "All Patients Information", Toast.LENGTH_LONG).show();
        }

    }
