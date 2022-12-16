package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//ap context,activity context,getapplication context
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"toast message",Toast.LENGTH_LONG).show();
    }
    public void save(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(this)
                ;
        alert.setTitle("save");
        alert.setMessage("are u sure?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"saved",Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"KAYDEDİLMEDİ",Toast.LENGTH_LONG).show();

            }
        });
        alert.show();
    }
}