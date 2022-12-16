package com.example.mybos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Mydata extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME="ilan kutuphanesi";
    private static final int DATABASE_VERSİON=1;

    private static final String TABLE_NAME="İLANLARIM TABLOSU";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_TİTLE="KONU";
    private static final String COLUMN_AUTHOR="YAZAR";
    private static final String COLUMN_PAGES="SAYFA SAYİSİ";
    public Mydata(@Nullable Context context) {

        super(context,DATABASE_NAME, null,DATABASE_VERSİON);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE " + TABLE_NAME +
                " (" +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TİTLE + " Text, " +
                COLUMN_AUTHOR + " Text, " +
                COLUMN_PAGES + "INTEGER);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE İF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addBook(String title,String author,int pages){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_TİTLE,title);
        cv.put(COLUMN_AUTHOR,title);
        cv.put(COLUMN_PAGES,title);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==1){
            Toast.makeText(context,"hata",Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(context, "ekleme basarılı", Toast.LENGTH_SHORT).show();
        }
    }
}

