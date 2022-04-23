package com.rex1997.tugasakb;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Pertama dibuat pada 22 April 2022
// NIM      : 10121702
// NAMA     : BINA DAMAREKSA
// KELAS    : AKB IF-7

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "AKB_DB.db";
    public static final String TABLE_NAME = "users";
    public static final String COL_1 = "email";
    public static final String COL_2 = "password";

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users" + "(" + COL_1 + "TEXT PRIMARY KEY, " + COL_2 + "TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
}