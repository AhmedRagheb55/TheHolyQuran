package com.example.ahmedx64.recyclerview.Radio;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmedx64.recyclerview.MyBase.MyBaseFragment;
import com.example.ahmedx64.recyclerview.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ahmed x64 on 4/8/2018.
 */

public class infoFragment extends MyBaseFragment {

    private final String JSON_URL = "http://mp3quran.net/api/radio/radio_ar.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<quran> lstquran;
    private RecyclerView recyclerView;
    private ImageButton buttonplay ;
    private ImageButton buttonstop ;

    public infoFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.radiorec, container, false);
        lstquran = new ArrayList<>();
        buttonplay = view.findViewById(R.id.buttonplay);
        buttonstop = view.findViewById(R.id.buttonstop);
        recyclerView = view.findViewById(R.id.recradio);

        jsonParse();



        return view;

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

        requestQueue = Volley.newRequestQueue(activity);
        requestQueue.add(request);}







    private  void setuprecyclerview(List<quran> lstquran) {

        RecyclerAdapterRadio myadapter = new RecyclerAdapterRadio(activity,lstquran);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,true));
        recyclerView.setAdapter(myadapter);



    }






}
