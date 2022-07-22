package com.example.myapplication.Carer;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;

import java.util.ArrayList;

public class UsersShoppingList extends AppCompatActivity {

    DBHelper dbHelper;
    ListView listView;
    Cursor cursor;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_shopping_list);

        dbHelper = new DBHelper(this);
        Cursor data = dbHelper.getShoppingData();

        ArrayList<String> theList = new ArrayList<>();
        listView = findViewById(R.id.listViewShop);
        if (data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this shopping list", Toast.LENGTH_LONG).show();
//        search();

        } else
            {
            while (data.moveToNext()) {
                //col 0 is username this can be changed
                theList.add(data.getString(0));
                theList.add(data.getString(1));
                theList.add(data.getString(2));
                theList.add(data.getString(3));
                theList.add(data.getString(4));
                theList.add(data.getString(5));
                theList.add(data.getString(6));
                theList.add(data.getString(7));
                theList.add(data.getString(8));
          

                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                    listView.setAdapter(listAdapter);
                }
            }
        }
    }

