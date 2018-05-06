package com.example.ahmedx64.recyclerview;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ahmedx64.recyclerview.Quran.QuranFragment;

public class splashh extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashh);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashh.this,MainActivity.class));
                finish();

            }
        },2000);

    }

   }
