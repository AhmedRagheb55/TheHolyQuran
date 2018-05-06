package com.example.ahmedx64.recyclerview.Hadeeth;

import java.util.ArrayList;

/**
 * Created by ahmed x64 on 4/14/2018.
 */

public class HadeethData {
    int id;
    ArrayList<String> hadeethLines;


    public HadeethData(int id, ArrayList<String> hadeethLines) {
        this.id = id;
        this.hadeethLines = hadeethLines;
    }

    public String gethadethcontent (){
        String hadeethtxt="";
        for(int i = 0 ; i <hadeethLines.size() ; i++){
            hadeethtxt=hadeethtxt+hadeethLines.get(i);
        }
        return hadeethtxt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getHadeethLines() {
        return hadeethLines;
    }

    public void setHadeethLines(ArrayList<String> hadeethLines) {
        this.hadeethLines = hadeethLines;
    }
}



