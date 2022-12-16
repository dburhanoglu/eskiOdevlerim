package com.example.roomdeneme2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="ilan kutuphanesi";
    private static final int DATABASE_VERSİON=1;

    private static final String TABLE_NAME="İLANLARIM TABLOSU";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TİTLE="KONU";
    private static final String COLUMN_AUTHOR="YAZAR";
    private static final String COLUMN_PAGES="SAYFA SAYİSİ";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME, null,DATABASE_VERSİON);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
String query="CREATE TABLE" + TABLE_NAME +
                " (" +COLUMN_ID +"INTEGER PRIMARY KEY AUTOINCREMENT, " +
             COLUMN_TİTLE + " Text, " +
             COLUMN_AUTHOR  + " Text, " +
             COLUMN_PAGES + "INTEGER);";
db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE İF EXISTS " + TABLE_NAME);
onCreate(db);
    }
}
