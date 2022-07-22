package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public static final String TAG = DBHelper.class.getSimpleName();
    public static final String DB_NAME = "signin.db";

    public static final String USER_TABLE = "users";
    public static final String DISABLED_USER_TABLE = "duusers";
    public static final String USER_SHOP = "shop";
    public static final String USER_LOG = "log";
    public static final String USER_PREF="pref";
    public static final String COL_ID = "ID ";
    public static final String COL_DUID = "DUID ";
    public static final String COL_NAME = "name";
    public static final String COL_EMAIL = "username";
    public static final String COL_NUMBER = "number";
    public static final String COL_EMERGENCYNUMBER = "enumber";
    public static final String COL_PASS = "password";
    public static final String COL_REPASS = "repass";
    public static final String COL_WELLBEING = "well";

    public static final String COL_DUNAME = "duname";
    public static final String COL_DUEMAIL = "duusername";
    public static final String COL_DUPASS = "dupassword";
    public static final String COL_DUREPASS = "durepass";
    public static final String GROUP_ID = "groupid";
    public static final String COL_SHOP_ITEM1 = "Name";
    public static final String COL_SHOP_ITEM2 = "Date";
    public static final String COL_SHOP_ITEM3 = "Mobile";
    public static final String COL_SHOP_ITEM4 = "item4";
    public static final String COL_SHOP_ITEM5 = "item5";
    public static final String COL_SHOP_ITEM6 = "item6";
    public static final String COL_SHOP_ITEM7 = "item7";
    public static final String COL_SHOP_ITEM8 = "item8";
    public static final String COL_SHOP_ITEM9 = "item9";
    public static final String COL_SHOP_ITEM10 = "item10";

    public static final String COL_DUPREFERENCES = "dupref";
    public static final String COL_PREF_ITEM1 = "PName";
    public static final String COL_PREF_ITEM2 = "Pitem2";
    public static final String COL_PREF_ITEM3 = "Pitem3";
    public static final String COL_PREF_ITEM4 = "Pitem4";
    public static final String COL_PREF_ITEM5 = "Pitem5";
    public static final String COL_PREF_ITEM6 = "Pitem6";
    public static final String COL_PREF_ITEM7 = "Pitem7";
    public static final String COL_PREF_ITEM8 = "Pitem8";
    public static final String COL_PREF_ITEM9 = "Pitem9";
    public static final String COL_PREF_ITEM10 = "Pitem10";

    public static final String COL_DUPWELLBEINGLOG = "dulog";
    public static final String COL_LOG_NOTE1 = "LName";
    public static final String COL_LOG_NOTE2 = "note2";
    public static final String COL_LOG_NOTE3 = "note3";
    public static final String COL_LOG_NOTE4 = "note4";
    public static final String COL_LOG_NOTE5 = "note5";
    public static final String COL_LOG_NOTE6 = "note6";
    public static final String COL_LOG_NOTE7 = "note7";
    public static final String COL_LOG_NOTE8 = "note8";
    public static final String COL_LOG_NOTE9 = "note9";
    public static final String COL_LOG_NOTE10 = "note10";


    public SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        onConfigure(db);
        //carer db
        db.execSQL("CREATE TABLE " + USER_TABLE + " (\n" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                COL_NAME + " TEXT NOT NULL,\n" +
                COL_EMAIL + " TEXT NOT NULL,\n" +
                COL_PASS + " TEXT NOT NULL,\n" +
                COL_REPASS + " TEXT NOT NULL\n" + ");");

        //disabled user database
        db.execSQL(" CREATE TABLE " + DISABLED_USER_TABLE +
                "(" + COL_DUID + " INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + COL_DUNAME + " TEXT, "
                + COL_DUEMAIL + " TEXT, "
                + COL_DUPASS + " TEXT, "
                + COL_DUREPASS + " TEXT, "
                +  COL_NUMBER + " INTEGER, "
                +  COL_EMERGENCYNUMBER + " INTEGER "
                + ")");

        //shop db
        db.execSQL("CREATE TABLE " + USER_SHOP + " (\n" +
                COL_ID + "INTEGER PRIMARY KEY ,\n" +
//                GROUP_ID +" TEXT NOT NULL,\n" +
                COL_SHOP_ITEM1 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM2 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM3 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM4 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM5 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM6 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM7 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM8 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM9 + " TEXT NOT NULL, \n" +
                COL_SHOP_ITEM10 + " TEXT NOT NULL, \n" +
                "    FOREIGN KEY (" + COL_ID + ") REFERENCES " + USER_TABLE + " (" + COL_ID + ")\n" +
                ");");// taking COL_ID FROM FIRST TABLE AND REFERING TO IT FROM USER_TABLE AND PUTTING IT INTO GROUP ID


        db.execSQL("CREATE TABLE " + USER_PREF + " (\n" +
                COL_ID + "INTEGER PRIMARY KEY ,\n" +
//                GROUP_ID +" TEXT NOT NULL,\n" +
                COL_PREF_ITEM1 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM2 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM3 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM4 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM5 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM6 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM7 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM8 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM9 + " TEXT NOT NULL, \n" +
                COL_PREF_ITEM10 + " TEXT NOT NULL, \n" +
                "    FOREIGN KEY (" + COL_ID + ") REFERENCES " + USER_TABLE + " (" + COL_ID + ")\n" +
                ");");

        db.execSQL("CREATE TABLE " + USER_LOG + " (\n" +
                COL_ID + "INTEGER PRIMARY KEY ,\n" +
//                GROUP_ID +" TEXT NOT NULL,\n" +
                COL_LOG_NOTE1 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE2 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE3 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE4 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE5 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE6 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE7 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE8 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE9 + " TEXT NOT NULL, \n" +
                COL_LOG_NOTE10 + " TEXT NOT NULL, \n" +
                "    FOREIGN KEY (" + COL_ID + ") REFERENCES " + USER_TABLE + " (" + COL_ID + ")\n" +
                ");");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DISABLED_USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + USER_SHOP);
        db.execSQL("DROP TABLE IF EXISTS " + USER_PREF);
        db.execSQL("DROP TABLE IF EXISTS " + USER_LOG);
        onCreate(db);
    }


    public void addUser(String name, String username, String password, String repass) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, username);
        values.put(COL_PASS, password);
        values.put(COL_REPASS, repass);


        db.insert(USER_TABLE, null, values);
        db.close();
    }

    public void addDUUser(String name, String username, String password, String repass, String number, String enumber) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_DUNAME, name);
        values.put(COL_DUEMAIL, username);
        values.put(COL_DUPASS, password);
        values.put(COL_DUREPASS, repass);
        values.put(COL_NUMBER, number);
        values.put(COL_EMERGENCYNUMBER, enumber);


        db.insert(DISABLED_USER_TABLE, null, values);
        db.close();
    }



    public boolean addShopping(String Name, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9, String item10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //need to change the shop string
        values.put(COL_SHOP_ITEM1, Name);
        values.put(COL_SHOP_ITEM2, item2);
        values.put(COL_SHOP_ITEM3, item3);
        values.put(COL_SHOP_ITEM4, item4);
        values.put(COL_SHOP_ITEM5, item5);
        values.put(COL_SHOP_ITEM6, item6);
        values.put(COL_SHOP_ITEM7, item7);
        values.put(COL_SHOP_ITEM8, item8);
        values.put(COL_SHOP_ITEM9, item9);
        values.put(COL_SHOP_ITEM10, item10);

        //figure out how to have the same amount of items to be inserted
        long result = db.insert(USER_SHOP, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String Name, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9, String item10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SHOP_ITEM1, Name);
        values.put(COL_SHOP_ITEM2, item2);
        values.put(COL_SHOP_ITEM3, item3);
        values.put(COL_SHOP_ITEM4, item4);
        values.put(COL_SHOP_ITEM5, item5);
        values.put(COL_SHOP_ITEM6, item6);
        values.put(COL_SHOP_ITEM7, item7);
        values.put(COL_SHOP_ITEM8, item8);
        values.put(COL_SHOP_ITEM9, item9);
        values.put(COL_SHOP_ITEM10, item10);

        db.update(USER_SHOP, values, "Name=?", new String[]{Name});
        return true;
    }
    public boolean deleteData(String Name, String item2, String item3, String item4, String item5, String item6, String item7, String item8, String item9, String item10) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from shop where Name=?", new String[]{Name});

        if (cursor.getCount() > 0) {
            long result = db.delete("shop", "name=?", new String[]{Name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;

        }
    }



    public Cursor getName() {//selects all information from database * is all
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM users WHERE ROWID = 1 limit 1 ", null);
    }


    public Cursor getListContents() {//selects all users from database
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM duusers " + DISABLED_USER_TABLE, null);
        return data;
    }

    public Cursor getDisabledUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM duuser " + DISABLED_USER_TABLE, null);
        return data;
    }


    public Cursor getShoppingData() {//selects all information from database * is all
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("select * from shop ", null);
    }

    public Cursor getPreferenceData() {//selects all information from database * is all
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("select * from pref "+ USER_PREF, null);
    }

    public Cursor getLogData() {//selects all information from database * is all
        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("select * from log "+ USER_LOG, null);
    }
    public Cursor getUser1Info() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data1 = db.rawQuery("select * from duusers where duid =1", null);
        return data1;
    }

    public Cursor getUser2Info() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data2 = db.rawQuery("select * from duusers where duid =2", null);
        return data2;
    }

    public boolean updatePref(String PName, String Pitem2, String Pitem3, String Pitem4, String Pitem5, String Pitem6, String Pitem7, String Pitem8, String Pitem9, String Pitem10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_PREF_ITEM1, PName);
        values.put(COL_PREF_ITEM2, Pitem2);
        values.put(COL_PREF_ITEM3, Pitem3);
        values.put(COL_PREF_ITEM4, Pitem4);
        values.put(COL_PREF_ITEM5, Pitem5);
        values.put(COL_PREF_ITEM6, Pitem6);
        values.put(COL_PREF_ITEM7, Pitem7);
        values.put(COL_PREF_ITEM8, Pitem8);
        values.put(COL_PREF_ITEM9, Pitem9);
        values.put(COL_PREF_ITEM10, Pitem10);

        db.update(USER_PREF, values, "PName=?", new String[]{PName});
        return true;
    }
    public boolean addPref(String PName, String Pitem2, String Pitem3, String Pitem4, String Pitem5, String Pitem6, String Pitem7, String Pitem8, String Pitem9, String Pitem10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //need to change the shop string
        values.put(COL_PREF_ITEM1, PName);
        values.put(COL_PREF_ITEM2, Pitem2);
        values.put(COL_PREF_ITEM3, Pitem3);
        values.put(COL_PREF_ITEM4, Pitem4);
        values.put(COL_PREF_ITEM5, Pitem5);
        values.put(COL_PREF_ITEM6, Pitem6);
        values.put(COL_PREF_ITEM7, Pitem7);
        values.put(COL_PREF_ITEM8, Pitem8);
        values.put(COL_PREF_ITEM9, Pitem9);
        values.put(COL_PREF_ITEM10, Pitem10);

        //figure out how to have the same amount of items to be inserted
        long result = db.insert(USER_PREF, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean deletePreferences(String PName, String Pitem2, String Pitem3, String Pitem4, String Pitem5, String Pitem6, String Pitem7, String Pitem8, String Pitem9, String Pitem10) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from pref where PName=?", new String[]{PName});

        if (cursor.getCount() > 0) {
            long result = db.delete("pref", "PName=?", new String[]{PName});//change everything to the same thing such as PName
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;

        }
    }

    public boolean addLog(String LName, String note2, String note3, String note4, String note5, String note6, String note7, String note8, String note9, String note10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //need to change the shop string
        values.put(COL_LOG_NOTE1, LName);
        values.put(COL_LOG_NOTE2, note2);
        values.put(COL_LOG_NOTE3, note3);
        values.put(COL_LOG_NOTE4, note4);
        values.put(COL_LOG_NOTE5, note5);
        values.put(COL_LOG_NOTE6, note6);
        values.put(COL_LOG_NOTE7, note7);
        values.put(COL_LOG_NOTE8, note8);
        values.put(COL_LOG_NOTE9, note9);
        values.put(COL_LOG_NOTE10, note10);

        //figure out how to have the same amount of items to be inserted
        long result = db.insert(USER_LOG, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
    public boolean updateLog(String LName, String note2, String note3, String note4, String note5, String note6, String note7, String note8, String note9, String note10) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_LOG_NOTE1, LName);
        values.put(COL_LOG_NOTE2, note2);
        values.put(COL_LOG_NOTE3, note3);
        values.put(COL_LOG_NOTE4, note4);
        values.put(COL_LOG_NOTE5, note5);
        values.put(COL_LOG_NOTE6, note6);
        values.put(COL_LOG_NOTE7, note7);
        values.put(COL_LOG_NOTE8, note8);
        values.put(COL_LOG_NOTE9, note9);
        values.put(COL_LOG_NOTE10, note10);

        db.update(USER_LOG, values, "LName=?", new String[]{LName});
        return true;
    }
    public boolean deleteLog(String LName, String note2, String note3, String note4, String note5, String note6, String note7, String note8, String note9, String note10) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from log where LName=?", new String[]{LName});

        if (cursor.getCount() > 0) {
            long result = db.delete("log", "LName=?", new String[]{LName});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;

        }
    }

}