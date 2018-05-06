package com.example.ahmedx64.recyclerview.Quran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ahmedx64.recyclerview.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ahmed x64 on 4/10/2018.
 */

public class ShowQuranSura extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quraan);
/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.tablayout_id);
        setSupportActionBar(toolbar);
*/

        String filename=getIntent()
                .getStringExtra("id");
        if (filename!=null){
            filename=filename+".txt";
        }

        Log.e("filename",filename);

        recyclerView=findViewById(R.id.recyclerquran);

        ArrayList<QuranData> mData;
        mData=ReadSura(filename);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(mData);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }


    ArrayList<QuranData> ReadSura(String filename){

        ArrayList<QuranData> alllines=new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            int id=0;
            while ((mLine = reader.readLine()) != null) {
                alllines.add(new QuranData(id,mLine));
                Log.e("line",mLine);
                id++;
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return alllines;
    }



}

