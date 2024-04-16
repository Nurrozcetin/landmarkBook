package com.example.landmarkbook;

public class Singleton {
    private Landmark sentLandmark;
    private static Singleton singleton;
    private Singleton(){

    }

    public Landmark getSentLandmark() {
        return sentLandmark;
    }

    public void setSentLandmark(Landmark sentLandmark) {
        this.sentLandmark = sentLandmark;
    }

    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

//her zaman ayni oobjeyi olusturur farkli yerlerden cagrilsa da