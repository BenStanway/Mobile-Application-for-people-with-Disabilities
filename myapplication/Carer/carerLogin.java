package com.example.myapplication.Carer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class carerLogin extends AppCompatActivity {

    EditText Email, pass, name;
    Button login;
    TextView AddUserBtn;
    Cursor cursor;
    CheckBox show;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carer_login);
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        AddUserBtn = (TextView) findViewById(R.id.AddUserBtn);
        name= (EditText)findViewById(R.id.FullName);
        Email = (EditText) findViewById(R.id.EmailTxt);
        pass = (EditText) findViewById(R.id.PassTxt);
        show = (CheckBox) findViewById(R.id.SeePassword);

        login = (Button)findViewById(R.id.loginBtn);
        showPass();

        AddUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(carerLogin.this, addCarer.class);
                startActivity(intent);
                finish();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cursor = db.rawQuery("SELECT * FROM users " + DBHelper.USER_TABLE + " WHERE "
                                + DBHelper.COL_EMAIL + " =? AND " + DBHelper.COL_PASS + " =?",
                        new String[]{Email.getText().toString(), pass.getText().toString()});

                if(Email.getText().toString().equals("")||
                        pass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Email and Password can't be empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();

                        Toast.makeText(carerLogin.this, "Logged In succesfully!",
                                Toast.LENGTH_LONG).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(carerLogin.this);

                        builder.setTitle("logged in");
                        builder.setMessage("Welcome");

                        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent openMenuIntent = new Intent(getApplicationContext(), carerMenu.class);
                                startActivity(openMenuIntent);
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        Toast.makeText(carerLogin.this, "Invalid email or password!",
                                Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    public void showPass(){
        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }


    public void onBackPressed()
    {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                       startActivity(intent);
                       finish();
                    }
                }).setNegativeButton("No", null).show();
    }
}