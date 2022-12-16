package com.example.odevdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText konu_input, durum_input, sayi_input;
    Button ekle_buton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        konu_input = findViewById(R.id.konu_input);
        durum_input = findViewById(R.id.durum_input);
        sayi_input = findViewById(R.id.sayi_input);
        ekle_buton = findViewById(R.id.ekle_buton);
        ekle_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(konu_input.getText().toString().trim(),
                        durum_input.getText().toString().trim(),
                        Integer.valueOf(sayi_input.getText().toString().trim()));
            }
        });
    }
}