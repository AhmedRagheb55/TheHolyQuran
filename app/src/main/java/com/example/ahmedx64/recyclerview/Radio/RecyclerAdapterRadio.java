package com.example.ahmedx64.recyclerview.Radio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmedx64.recyclerview.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed x64 on 4/22/2018.
 */

public class RecyclerAdapterRadio extends RecyclerView.Adapter<RecyclerAdapterRadio.MyViewHolder> {

    private Context context;
    List<quran> mData;
    RecyclerAdapterRadio.onclick onitemclickles ;
    MediaPlayer mediaPlayer = new MediaPlayer();

    public void setOnitemclickles(RecyclerAdapterRadio.onclick onitemclickles) {
        this.onitemclickles = onitemclickles;
    }
    public RecyclerAdapterRadio(ArrayList<quran> mData) {

        this.mData=mData;
    }

    public RecyclerAdapterRadio(Context context, List<quran> mData) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.textView.setText(mData.get(position).getName());
        holder.btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = mData.get(position).getUrllll();
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.reset();// It requires again setDataSource for player object.
                    mediaPlayer.stop();// Stop it

                    }



                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();



                Toast.makeText(context,  " "+url, Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.reset();// It requires again setDataSource for player object.
                mediaPlayer.stop();//
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView ;
        ImageButton btnplay ;
        ImageButton btnstop ;
        private LinearLayout radio;



        public MyViewHolder(View itemView) {
            super(itemView);

            radio = itemView.findViewById(R.id.item_radio_id);

            textView =  itemView.findViewById(R.id.txtv);
            btnplay =  itemView.findViewById( R.id.buttonplay );
            btnstop =  itemView.findViewById( R.id.buttonstop );

        }
    }
}
