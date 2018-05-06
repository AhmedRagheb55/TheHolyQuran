package com.example.ahmedx64.recyclerview.Hadeeth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ahmedx64.recyclerview.Quran.QuranData;
import com.example.ahmedx64.recyclerview.Quran.RecyclerViewAdapter;
import com.example.ahmedx64.recyclerview.Quran.ShowQuranSura;
import com.example.ahmedx64.recyclerview.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed x64 on 4/8/2018.
 */

public class HadeethFragment extends Fragment {

    private ArrayList<HadeethData> listhadeeth;
    private RecyclerView hadeethrecyclerview;
    private HadeethRecyclerAdapter adapter;
    Context context ;
    HadeethDialogFragment hadeethDialogFragment;
    HadeethData hadeethData;

    public HadeethFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hadeeth,container,false);
        hadeethrecyclerview = ( RecyclerView) view.findViewById(R.id.recyclerhadeeth);
        listhadeeth=ReadAhadeth();
        adapter = new HadeethRecyclerAdapter(listhadeeth);
        hadeethrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        hadeethrecyclerview.setAdapter(adapter);

        adapter.setOnitemclickles(new HadeethRecyclerAdapter.onclick() {
            @Override
            public void onitemclick(int position) {

                hadeethDialogFragment = new HadeethDialogFragment();
                hadeethDialogFragment.setHadeethData(listhadeeth.get(position));
                hadeethDialogFragment.show(getChildFragmentManager(),"حديث");

            }
        });

        return view;
    }




    ArrayList<HadeethData> ReadAhadeth(){

        ArrayList<HadeethData> AllHadeeth=new ArrayList<>();
        ArrayList<String> hadees= new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getActivity().getAssets().open("ahadith_arabic.txt"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            int id=0;

            HadeethData item=null;
            ArrayList<String>HadeathContent=new ArrayList<>();
            while ((mLine = reader.readLine()) != null) {

                if (mLine.equals("#")){
                    item=new HadeethData(id,HadeathContent);
                    AllHadeeth.add(item);
                    HadeathContent=new ArrayList<>();
                    id++;
                }else {
                    HadeathContent.add(mLine);
                }
                Log.e("line",mLine);
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

        return AllHadeeth;
    }

}
