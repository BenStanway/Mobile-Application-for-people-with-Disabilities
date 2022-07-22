package com.example.myapplication.DU;

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

public class DuLogin extends AppCompatActivity {

    EditText DUEmail, DUpass, DUname;
    Button DUlogin;
    TextView DUAddUserBtn;
    Cursor cursor;
    CheckBox show;
    DBHelper dbHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_login);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        DUAddUserBtn = (TextView) findViewById(R.id.DUAddUserBtn);
        DUEmail = (EditText) findViewById(R.id.DUEmailTxt);
        DUpass = (EditText) findViewById(R.id.DUPassTxt);
        show = (CheckBox) findViewById(R.id.DUuserPassword);

        DUlogin = (Button)findViewById(R.id.DUloginBtn);
        showPass();

        DUAddUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuLogin.this, addDu.class);
                startActivity(intent);
                finish();
            }
        });



        DUlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cursor = db.rawQuery("SELECT * FROM " + DBHelper.DISABLED_USER_TABLE + " WHERE "
                                + DBHelper.COL_DUEMAIL + " =? AND " + DBHelper.COL_DUPASS + " =?",
                        new String[]{DUEmail.getText().toString(), DUpass.getText().toString()});

                if(DUEmail.getText().toString().equals("")||
                        DUpass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Email and Password can't be empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();

                        Toast.makeText(DuLogin.this, "Logged In succesfully!",
                                Toast.LENGTH_LONG).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(DuLogin.this);

                        builder.setTitle("logged in");
                        builder.setMessage("Welcome");

                        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent openMenuIntent = new Intent(getApplicationContext(), shake.class);
                                startActivity(openMenuIntent);
                            }
                        });

                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        Toast.makeText(DuLogin.this, "Invalid email or password!",
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
                    DUpass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    DUpass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
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
                        Intent intent= new Intent(DuLogin.this, MainActivity.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("No", null).show();
    }
}