package com.example.ahmedx64.recyclerview.Radio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmedx64.recyclerview.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainRadio extends AppCompatActivity {

    private final String JSON_URL = "http://mp3quran.net/api/radio/radio_ar.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<quran> lstquran;
    private RecyclerView recyclerView;
    private ImageButton buttonplay ;
    private ImageButton buttonstop ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstquran = new ArrayList<>();
        buttonplay = findViewById(R.id.buttonplay);
        buttonstop = findViewById(R.id.buttonstop);


        recyclerView = findViewById(R.id.recradio);

        jsonParse();
    }


    private void jsonParse() {


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Radios");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject radio = jsonArray.getJSONObject(i);

                                final quran quranListen = new quran();
                                quranListen.setName(radio.getString("Name"));
                                quranListen.setUrllll(radio.getString("URL"));

                                lstquran.add(quranListen);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setuprecyclerview(lstquran);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue = Volley.newRequestQueue(MainRadio.this);
        requestQueue.add(request);}







    private  void setuprecyclerview(List<quran> lstquran) {

        RecyclerAdapterRadio myadapter = new RecyclerAdapterRadio(this,lstquran);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true));
        recyclerView.setAdapter(myadapter);



    }



}
