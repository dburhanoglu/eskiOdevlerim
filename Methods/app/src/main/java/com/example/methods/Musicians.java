package com.example.methods;

public class Musicians {
    String isim;
    String instrument;
    int age;

    public Musicians(String isim, String instrument, int age) {
        this.isim = isim;
        this.instrument = instrument;
        this.age = age;
        System.out.println("constructor cağrıldı");
    }

}
