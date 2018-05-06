package com.example.ahmedx64.recyclerview.Quran;

/**
 * Created by ahmed x64 on 4/8/2018.
 */

public class QuranData {


    int id;
    //public static String[] ArSuras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String txt;

    public QuranData(int id, String txt) {
        this.id = id;
        this.txt = txt;
    }

    public QuranData() {
    }

    public QuranData(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
