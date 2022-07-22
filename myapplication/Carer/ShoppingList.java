package com.example.myapplication.Carer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;

public class ShoppingList extends AppCompatActivity {

    EditText SHOP_ITEM1, SHOP_ITEM2, SHOP_ITEM3, SHOP_ITEM4, SHOP_ITEM5,
            SHOP_ITEM6, SHOP_ITEM7, SHOP_ITEM8, SHOP_ITEM9, SHOP_ITEM10;
    Button saveShop, viewShop, updateShop, deleteShop;
    DBHelper dbHelper;
    SQLiteDatabase db;
    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        SHOP_ITEM1 = findViewById(R.id.SHOP_ITEM1);
        SHOP_ITEM2 = findViewById(R.id.SHOP_ITEM2);
        SHOP_ITEM3 = findViewById(R.id.SHOP_ITEM3);
        SHOP_ITEM4 = findViewById(R.id.SHOP_ITEM4);
        SHOP_ITEM5 = findViewById(R.id.SHOP_ITEM5);
        SHOP_ITEM6 = findViewById(R.id.SHOP_ITEM6);
        SHOP_ITEM7 = findViewById(R.id.SHOP_ITEM7);
        SHOP_ITEM8 = findViewById(R.id.SHOP_ITEM8);
        SHOP_ITEM9 = findViewById(R.id.SHOP_ITEM9);
        SHOP_ITEM10 = findViewById(R.id.SHOP_ITEM10);



        updateShop= findViewById(R.id.updateShop);
        deleteShop=findViewById(R.id.deleteShop);
        deleteShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Boolean checkDeleteData= dbHelper.deleteData(SHOP_ITEM1.getText().toString(), SHOP_ITEM2.getText().toString(),
                        SHOP_ITEM3.getText().toString(), SHOP_ITEM4.getText().toString(),
                        SHOP_ITEM5.getText().toString(), SHOP_ITEM6.getText().toString(), SHOP_ITEM7.getText().toString(),
                        SHOP_ITEM8.getText().toString(), SHOP_ITEM9.getText().toString(), SHOP_ITEM10.getText().toString());

                if(checkDeleteData==true) {
                    Toast.makeText(ShoppingList.this, "ShoppingListDeleted", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(ShoppingList.this, "Shopping List Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        updateShopData();
        dbHelper = new DBHelper(this);
        viewShop = findViewById(R.id.viewShop);
        viewShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UsersShoppingList.class);
                startActivity(intent);
            }
        });

        saveShop = findViewById(R.id.saveShop);
        saveShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SHOP_ITEM1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Something onto the Shopping List", Toast.LENGTH_LONG).show();
                } else {
                    dbHelper.addShopping(SHOP_ITEM1.getText().toString(), SHOP_ITEM2.getText().toString(),
                            SHOP_ITEM3.getText().toString(), SHOP_ITEM4.getText().toString(),
                            SHOP_ITEM5.getText().toString(), SHOP_ITEM6.getText().toString(), SHOP_ITEM7.getText().toString(),
                            SHOP_ITEM8.getText().toString(), SHOP_ITEM9.getText().toString(), SHOP_ITEM10.getText().toString());
                    Toast.makeText(getApplicationContext(), "Shopping List Items entered", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void updateShopData(){
        updateShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated=dbHelper.updateData(SHOP_ITEM1.getText().toString(), SHOP_ITEM2.getText().toString(),
                        SHOP_ITEM3.getText().toString(), SHOP_ITEM4.getText().toString(),
                        SHOP_ITEM5.getText().toString(), SHOP_ITEM6.getText().toString(), SHOP_ITEM7.getText().toString(),
                        SHOP_ITEM8.getText().toString(), SHOP_ITEM9.getText().toString(), SHOP_ITEM10.getText().toString());

                if(isupdated==true){
                    Toast.makeText(getApplicationContext(), "Shopping List Items Updated", Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getApplicationContext(), "Shopping List Items not Updated", Toast.LENGTH_LONG).show();

                }
            }
        });

    }


}
