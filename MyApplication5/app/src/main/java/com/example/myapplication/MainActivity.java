package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User myUser=new User("yazılımcı","atil");
        System.out.println(myUser.information());
        System.out.println(myUser.job);
        Musician james=new Musician("james","gitar",50);
       // james.age=60;// age i musicians kısmına private yaparsan böyle yapınca ulaşamazsın
      //  System.out.println(james.age);
        System.out.println(james.getAge()); ///bu getter ve setterları kullanarak deger verme-okuma
     james.setAge(68,"atil");//islerini kendi kontrolümüze aldık
        System.out.println(james.getAge());
        SuperMusician lara=new SuperMusician("lara","gitar",50);
        System.out.println(lara.sing());
        System.out.println(lara.getAge());
        Mat mat1=new Mat();
        System.out.println(mat1.sum());
        System.out.println(mat1.sum(3,5));
        System.out.println(mat1.sum(3,6,9));
       //dynamic polymorphism
        Animal myanimal=new Animal();
        myanimal.sing();
        Dog barley=new Dog();
        barley.test();
        barley.sing();

//abstract &ınterface

        piano mypiano=new piano();
        mypiano.brand="yamaha";
        mypiano.digital=true;
        mypiano.info();
    }
}