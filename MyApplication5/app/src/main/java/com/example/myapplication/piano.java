package com.example.myapplication;

public class piano implements HouseDecor,Instruments{//sınıfların aksine b,rden fazla arayuzu implemente edebilirsin
String brand;  //bu da abstrat sınıfa göre üstün yanı
boolean digital;

    @Override
    public void info() {
        System.out.println("override metot");
    }
}
