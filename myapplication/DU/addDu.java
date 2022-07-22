package com.example.myapplication.DU;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;

public class addDu extends AppCompatActivity {

    EditText name1, username1, pass1, RePass1, number, enumber;
    Button signin;

    Cursor cursor;
    SQLiteDatabase db;
    CheckBox show;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_du);
        dbHelper = new DBHelper(this);

        name1 = findViewById(R.id.name1);
        pass1 =  findViewById(R.id.password1);
        RePass1 = findViewById(R.id.RePass1);
        username1 =  findViewById(R.id.email1);

        number=findViewById(R.id.Number);
        enumber= findViewById(R.id.EMERGENCYNumber);

        show = findViewById(R.id.showPass1);
        signin = findViewById(R.id.signin1);


        showPassDu();


    }
    public void signinBtn(View view) {

        if(name1.getText().toString().equals("")||
                username1.getText().toString().equals("")||
                pass1.getText().toString().equals("")|| RePass1.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please Enter Your Details", Toast.LENGTH_LONG).show();
            return;
        }

        // check if both password matches
        if(!pass1.getText().toString().equals(RePass1.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
        }



        else {
            dbHelper.addDUUser(name1.getText().toString(),
                    username1.getText().toString(), pass1.getText().toString(),
                    RePass1.getText().toString(), number.getText().toString(), enumber.getText().toString());

            Toast.makeText(getApplicationContext(), "New User Added", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(addDu.this, DuLogin.class);
            startActivity(intent);
        }

    }


    private void showPassDu(){
       show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    RePass1.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    pass1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    RePass1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(addDu.this, DuLogin.class);
        startActivity(intent);
        finish();
    }
}