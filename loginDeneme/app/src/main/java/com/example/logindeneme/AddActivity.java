package com.example.logindeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText baslikKismi,durumKismi,sayiKismi;
    Button durumekleButonum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        baslikKismi = findViewById(R.id.baslikKismi);
        durumKismi = findViewById(R.id.durumKismi);
       sayiKismi = findViewById(R.id.sayiKismi);
        durumekleButonum = findViewById(R.id.durumekleButonum);
        durumekleButonum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(baslikKismi.getText().toString().trim(),
                        durumKismi.getText().toString().trim(),
                        Integer.valueOf(sayiKismi.getText().toString().trim()));
            }
        });
    }
}