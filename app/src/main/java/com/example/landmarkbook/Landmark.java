package com.example.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {
    //serilestirilebilir sinif: veriyi bir yerden diger bi yre yollarken bunu veriye cevirip diger yerde tekrar kendisine donusturmek

    String name;
    String country;
    int image;

    public Landmark(String name, String country, int image){
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
