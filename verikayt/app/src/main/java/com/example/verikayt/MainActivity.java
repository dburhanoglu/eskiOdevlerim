package com.example.verikayt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;//kodd
//KODDA EKSİK KISIMLAR VAR


public class MainActivity extends AppCompatActivity {

    EditText edittext;
    TextView textview;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext=findViewById(R.id.editTextNumber);
        textview=findViewById(R.id.TextView);

 sharedPreferences=this.getSharedPreferences("com.example.verikayt", Context.MODE_PRIVATE);
int stored=sharedPreferences.getInt("stored",0);
textview.setText("yourage"+stored);



    }
    public void save(View view) {
        if (!edittext.getText().toString().matches("")) {
            int userage = Integer.parseInt(edittext.getText().toString());
            textview.setText("senin yasın" + userage);
            sharedPreferences.edit().putInt("stored", userage).apply();
        }

            }public void delete (View view){
                int storedData = sharedPreferences.getInt("stored", 0);
                if (storedData > 0 ||storedData<0) {
                    sharedPreferences.edit().remove("stored").apply();
                    textview.setText("yourage");

                }

    }

}
