package com.example.methods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("create called");

        makeMusaicans();
        simpsonsMaker();
    }
    public void simpsonsMaker(){
       Simpsons honer=new Simpsons(" honer",50,"doctor");
        System.out.println(honer.getName());
        honer.setName("buğra")
        ;
        System.out.println(honer.getName());

    }

    public int math(int a,int b){
        return a*b;
    }
    public void makeMusaicans(){
      Musicians james=new Musicians("jame","gitar",7);

        System.out.println(james.age);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("resume called");

    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stop called");
    }
}