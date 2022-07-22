package com.example.myapplication.Carer;

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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class addCarer extends AppCompatActivity {

    EditText name, email, pass, RePass, ID;
    Button signin;
    ImageView rback;
    Cursor cursor;
    SQLiteDatabase db;
    CheckBox show;
    DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_carer);
        dbHelper = new DBHelper(this);

        name = (EditText) findViewById(R.id.FullName);
        pass = (EditText) findViewById(R.id.password);
        RePass = (EditText) findViewById(R.id.RePass);
        email = (EditText) findViewById(R.id.email);
        ID=findViewById(R.id.IDNumber);

        show = (CheckBox) findViewById(R.id.showPass);
        signin = (Button) findViewById(R.id.signin);


        showPass();



    }
    public void signinBtn(View view) {

        if(name.getText().toString().equals("")||
                email.getText().toString().equals("")||
                pass.getText().toString().equals("")|| RePass.getText().toString().equals(""))//put a new editbox in to check correct id code(security)
        {
            Toast.makeText(getApplicationContext(), "Please Enter Your Details", Toast.LENGTH_LONG).show();
            return;
        }

        // check if both password matches
        if(!pass.getText().toString().equals(RePass.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
        }



        if(ID.getText().toString().equals("2000")){//security check
            dbHelper.addUser(name.getText().toString(),
                    email.getText().toString(), pass.getText().toString(),
                    RePass.getText().toString());

            Toast.makeText(addCarer.this, "New user created", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(addCarer.this, carerLogin.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(addCarer.this, "Enter the correct ID", Toast.LENGTH_LONG).show();
        }
    }


    public void showPass(){
        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    RePass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    RePass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(addCarer.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}