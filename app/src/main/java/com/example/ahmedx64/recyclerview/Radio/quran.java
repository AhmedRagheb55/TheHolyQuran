package com.example.ahmedx64.recyclerview.Radio;

import java.net.URL;

/**
 * Created by ahmed x64 on 4/22/2018.
 */

public class quran {
    private int id;
    private String name;
    private String urllll;
    private URL url;

    public quran(String name) {
        this.name = name;
    }

    public quran() {
    }

    public quran(int id, String name, String urllll, URL url) {
        this.id = id;
        this.name = name;
        this.urllll = urllll;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrllll() {
        return urllll;
    }

    public void setUrllll(String urllll) {
        this.urllll = urllll;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
