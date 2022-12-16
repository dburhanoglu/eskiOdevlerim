package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText number1text;
    EditText number2text;
    TextView resulttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         number1text=findViewById(R.id.sayıkısım1);
         number2text=findViewById(R.id.sayıkısım2);
         resulttext=findViewById(R.id.sonuckısım);
    }

    public void toplama(View view){
        if(number1text.getText().toString().matches("")||number2text.getText().toString().matches("")){
resulttext.setText("numara gir");
        }
        else{
        int number1=Integer.parseInt(number1text.getText().toString());
        int number2=Integer.parseInt(number2text.getText().toString());
int result =number1+number2 ;

resulttext.setText("result"+result);
    }
     }
 public void cikarma(View view){
        int number1=Integer.parseInt(number1text.getText().toString());
        int number2=Integer.parseInt(number2text.getText().toString());
        int result =number1-number2
                ;
    }
    public void carpma(View view){
        int number1=Integer.parseInt(number1text.getText().toString());
        int number2=Integer.parseInt(number2text.getText().toString());
        int result =number1*number2;

    }
    public void bolme(View view){
        int number1 = Integer.parseInt(number1text.getText().toString());
        int number2=Integer.parseInt(number2text.getText().toString());
        int result =number1/number2;
        System.out.println("bura");
    }
}