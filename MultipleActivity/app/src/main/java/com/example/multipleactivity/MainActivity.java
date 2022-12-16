package com.example.multipleactivity;
//aktiviteler arası geçiş ve bilgi aktarımı
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edittext2;
String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext2=findViewById(R.id.edittext2);
        username="";
    }
    public void changeActivity(View view){
        username=edittext2.getText().toString();
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("userınput",username);
startActivity(intent);

    }
}