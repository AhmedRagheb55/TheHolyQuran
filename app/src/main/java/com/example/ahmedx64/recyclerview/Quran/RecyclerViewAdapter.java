package com.example.ahmedx64.recyclerview.Quran;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmedx64.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by ahmed x64 on 4/8/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mcontext ;
    ArrayList<QuranData> mData ;
    TextView mytxt;
    Dialog myDialog;
    onclick onitemclickles;

    public void setOnitemclickles(onclick onitemclickles) {
        this.onitemclickles = onitemclickles;
    }

    private TextView fileContent;


//**
    public RecyclerViewAdapter(ArrayList<QuranData> mData) {

        this.mData=mData;
    }
//**
    @Override
    public MyViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemquran,parent,false);
         MyViewHolder vHolder = new MyViewHolder(v);




        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_txt.setText(mData.get(position).getTxt());


        holder.tv_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onitemclickles != null)
                    onitemclickles.onitemclick(position);
            }
        });

    }

    public  interface onclick{
        void onitemclick(int position);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item_quran;

         private  TextView tv_txt ;



        public MyViewHolder(View itemView) {
            super(itemView);
            item_quran =(LinearLayout) itemView.findViewById(R.id.item_radio_id);

            tv_txt = (TextView) itemView.findViewById(R.id.item_quran);
        }
    }

}
