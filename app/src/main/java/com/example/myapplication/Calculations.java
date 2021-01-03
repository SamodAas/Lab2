package com.example.myapplication;

public class Calculations {

    public static int calcByWords(String a){
        int x=0;
        String[]count = a.split("[ \\,\\.]+");
        x=count.length;
        return x;
    }
    public static int calcByChars(String a){
        int x=a.length();
        return x;
    }

}
