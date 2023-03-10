package com.example.odevdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText konu_input, durum_input, sayi_input;
    Button güncelle_button, sil_button;

    String id,konu, durum, sayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        konu_input = findViewById(R.id.konu_input2);
        durum_input = findViewById(R.id.durum_input2);
        sayi_input = findViewById(R.id.sayi_input2);
        güncelle_button= findViewById(R.id.güncelle_button);
        sil_button = findViewById(R.id.sil_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(konu);
        }

        güncelle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                konu= konu_input.getText().toString().trim();
                durum = durum_input.getText().toString().trim();
                sayi = sayi_input.getText().toString().trim();
                myDB.updateData(id, konu, durum, sayi);
            }
        });
        sil_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("konu") &&
                getIntent().hasExtra("durum") && getIntent().hasExtra("sayi")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            konu= getIntent().getStringExtra("konu");
            durum = getIntent().getStringExtra("durum");
            sayi = getIntent().getStringExtra("sayi");

            //Setting Intent Data
            konu_input.setText(konu);
            durum_input.setText(durum);
            sayi_input.setText(sayi);
            Log.d("stev", konu+" "+durum+" "+sayi);
        }else{
            Toast.makeText(this, "DATA YOK.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SİL " + konu + "'YU ?");
        builder.setMessage( ""+ konu + "'yu silmek istediğineemin misin?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}