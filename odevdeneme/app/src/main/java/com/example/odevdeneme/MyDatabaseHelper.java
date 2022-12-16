package com.example.odevdeneme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "DURUMLAR.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ADİ = "durumlarım/ilanlarım";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_KONU= "durum_konu";
    private static final String COLUMN_DURUM = "durum_durum";
    private static final String COLUMN_SAYİ = "durum_sayi";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ADİ +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_KONU + " TEXT, " +
                COLUMN_DURUM + " TEXT, " +
                COLUMN_SAYİ + " INTEGER);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADİ);
        onCreate(db);
    }

    void addBook(String KONU, String durum, int sayi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_KONU, KONU);
        cv.put(COLUMN_DURUM, durum);
        cv.put(COLUMN_SAYİ , sayi);
        long result = db.insert(TABLE_ADİ,null, cv);
        if(result == -1){
            Toast.makeText(context, "HATA!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "EKLEME BAŞARILI!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_ADİ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String konu, String durum, String sayi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_KONU, konu);
        cv.put(COLUMN_DURUM, durum);
        cv.put(COLUMN_SAYİ, sayi);

        long result = db.update(TABLE_ADİ, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "HATA!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "BAŞARIYLA GÜNCELLENDİ!", Toast.LENGTH_SHORT).show();
        }

    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_ADİ, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "SİLME BAŞARISIZ.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "BAŞARILI BİR ŞEKİLDE SİLİNDİ", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ADİ);
    }

}