package com.example.logindeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DbHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Kullanicilar(kullaniciAdi TEXT primary key, sifreKismi TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists kullanicilar"); //sql kullandıgımızı gösterir
    }
    public Boolean insertData(String kullaniciAdi, String sifreKismi){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("kullaniciAdi", kullaniciAdi);
        contentValues.put("sifreKismi", sifreKismi);
        long result = MyDB.insert("kullanicilar", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    } public Boolean checkusername(String kullaniciAdi) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from kullanicilar where kullaniciAdi = ?", new String[]{kullaniciAdi});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public Boolean checkusernamepassword(String kullaniciAdi, String sifreKismi){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from kullanicilar where kullaniciAdi = ? and sifreKismi = ?", new String[] {kullaniciAdi,sifreKismi});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


}