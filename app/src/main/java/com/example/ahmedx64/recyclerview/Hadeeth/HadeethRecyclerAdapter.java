package com.example.ahmedx64.recyclerview.Hadeeth;

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
 * Created by ahmed x64 on 4/14/2018.
 */

public class HadeethRecyclerAdapter extends RecyclerView.Adapter<HadeethRecyclerAdapter.HadeethViewHolder> {

    Context mcontext ;
    ArrayList<HadeethData> HData ;
    TextView mytxt;
    Dialog myDialog;
    HadeethRecyclerAdapter.onclick onitemclickles;

    public void setOnitemclickles(HadeethRecyclerAdapter.onclick onitemclickles) {
        this.onitemclickles = onitemclickles;
    }

    private TextView fileContent;


    //**
    public HadeethRecyclerAdapter(ArrayList<HadeethData> HData) {

        this.HData=HData;
    }


    @Override
    public HadeethViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemhadeeth,parent,false);
        HadeethRecyclerAdapter.HadeethViewHolder vHolder = new HadeethRecyclerAdapter.HadeethViewHolder(v);




        return vHolder;
    }

    @Override
    public void onBindViewHolder(HadeethViewHolder holder, final int position) {



        holder.tv_txt.setText(HData.get(position).getHadeethLines().get(0));


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
        return HData.size();
    }

    public static class HadeethViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_hadeeth;

        private  TextView tv_txt ;
        public HadeethViewHolder(View itemView) {
            super(itemView);
            item_hadeeth =(LinearLayout) itemView.findViewById(R.id.item_hadeeth_id);

            tv_txt = (TextView) itemView.findViewById(R.id.item_hadeeth);
        }
    }
}
