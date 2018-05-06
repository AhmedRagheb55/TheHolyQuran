package com.example.ahmedx64.recyclerview.Quran;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ahmedx64.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed x64 on 4/8/2018.
 */

public class QuranFragment extends Fragment {

    private List<QuranData> listquraan;
    private RecyclerView qurrecyclerview;
    private RecyclerViewAdapter adapter;
    Context context ;





    public QuranFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quraan,container,false);
        qurrecyclerview = ( RecyclerView) view.findViewById(R.id.recyclerquran);
        adapter = new RecyclerViewAdapter( (ArrayList<QuranData>) listquraan);
        qurrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        qurrecyclerview.setAdapter(adapter);
        adapter.setOnitemclickles(new RecyclerViewAdapter.onclick() {
            @Override
            public void onitemclick(int position) {
                Intent i =new Intent(getContext(),ShowQuranSura.class);
                i.putExtra("id",(position+1 )+"");
              startActivity(i);
                Toast.makeText(getContext() , "بسم الله الرحمن الرحيم", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


      /* */


        //


//
        listquraan = new ArrayList<>();
        listquraan.add(new QuranData("الفاتحة"));
        listquraan.add(new QuranData("البقرة"));
        listquraan.add(new QuranData("آل عمران"));
        listquraan.add(new QuranData("النساء"));
        listquraan.add(new QuranData("المائدة"));
        listquraan.add(new QuranData("الأنعام"));
        listquraan.add(new QuranData("الأعراف"));
        listquraan.add(new QuranData(" الأنفال   "));
        listquraan.add(new QuranData(" التوبة   "));
        listquraan.add(new QuranData("  يونس  "));
        listquraan.add(new QuranData(" يوسف   "));
        listquraan.add(new QuranData("  الرعد  "));
        listquraan.add(new QuranData("  إبراهيم  "));
        listquraan.add(new QuranData("  الحجر  "));
        listquraan.add(new QuranData("  النحل  "));
        listquraan.add(new QuranData("   الإسراء "));
        listquraan.add(new QuranData("  الكهف  "));
        listquraan.add(new QuranData(" مريم   "));
        listquraan.add(new QuranData("  طه  "));
        listquraan.add(new QuranData("  الأنبياء  "));
        listquraan.add(new QuranData("  الحج  "));
        listquraan.add(new QuranData("  المؤمنون  "));
        listquraan.add(new QuranData("  النّور  "));
        listquraan.add(new QuranData(" الفرقان   "));
        listquraan.add(new QuranData("  الشعراء  "));
        listquraan.add(new QuranData("   النّمل "));
        listquraan.add(new QuranData("  القصص  "));
        listquraan.add(new QuranData(" الرّوم   "));
        listquraan.add(new QuranData("  العنكبوت  "));
        listquraan.add(new QuranData("  لقمان  "));
        listquraan.add(new QuranData("  السجدة  "));
        listquraan.add(new QuranData(" الأحزاب   "));
        listquraan.add(new QuranData("  سبأ  "));
        listquraan.add(new QuranData("  فاطر  "));
        listquraan.add(new QuranData("   يس "));
        listquraan.add(new QuranData("   ص "));
        listquraan.add(new QuranData("  الزمر  "));
        listquraan.add(new QuranData(" غافر   "));
        listquraan.add(new QuranData("  فصّلت  "));
        listquraan.add(new QuranData("  الشورى  "));
        listquraan.add(new QuranData(" الزخرف   "));
        listquraan.add(new QuranData("  الدّخان  "));
        listquraan.add(new QuranData("   الزخرف "));
        listquraan.add(new QuranData("   الجاثية "));
        listquraan.add(new QuranData("  الأحقاف  "));
        listquraan.add(new QuranData(" محمد   "));
        listquraan.add(new QuranData("الفتح"));
        listquraan.add(new QuranData("الحجرات"));
        listquraan.add(new QuranData("ق"));
        listquraan.add(new QuranData("الذاريات"));
        listquraan.add(new QuranData("الطور"));
        listquraan.add(new QuranData("النجم"));
        listquraan.add(new QuranData("القمر"));
        listquraan.add(new QuranData("الرحمن"));
        listquraan.add(new QuranData("الواقعة"));
        listquraan.add(new QuranData("الحديد"));
        listquraan.add(new QuranData("المجادلة"));
        listquraan.add(new QuranData("الحشر"));
        listquraan.add(new QuranData("الممتحنة"));
        listquraan.add(new QuranData("الصف"));
        listquraan.add(new QuranData("الجمعة"));
        listquraan.add(new QuranData("المنافقون"));
        listquraan.add(new QuranData("التغابن"));
        listquraan.add(new QuranData("الطلاق"));
        listquraan.add(new QuranData("التحريم"));
        listquraan.add(new QuranData("الملك"));
        listquraan.add(new QuranData("القلم"));
        listquraan.add(new QuranData("الحاقة"));
        listquraan.add(new QuranData("المعارج"));
        listquraan.add(new QuranData("نوح"));
        listquraan.add(new QuranData("الجن"));
        listquraan.add(new QuranData("المزّمّل"));
        listquraan.add(new QuranData("المدّثر"));
        listquraan.add(new QuranData("القيامة"));
        listquraan.add(new QuranData("الإنسان"));
        listquraan.add(new QuranData("المرسلات"));
        listquraan.add(new QuranData("النبأ"));
        listquraan.add(new QuranData("النازعات"));
        listquraan.add(new QuranData("عبس"));
        listquraan.add(new QuranData("التكوير"));
        listquraan.add(new QuranData("الإنفطار"));
        listquraan.add(new QuranData("المطفّفين"));
        listquraan.add(new QuranData("الإنشقاق"));
        listquraan.add(new QuranData("البروج"));
        listquraan.add(new QuranData("الطارق"));
        listquraan.add(new QuranData("الأعلى"));
        listquraan.add(new QuranData("الغاشية"));
        listquraan.add(new QuranData("الفجر"));
        listquraan.add(new QuranData("البلد"));
        listquraan.add(new QuranData("الشمس"));
        listquraan.add(new QuranData("الليل"));
        listquraan.add(new QuranData("الضحى"));
        listquraan.add(new QuranData("الشرح"));
        listquraan.add(new QuranData("التين"));
        listquraan.add(new QuranData("العلق"));
        listquraan.add(new QuranData("القدر"));
        listquraan.add(new QuranData("البينة"));
        listquraan.add(new QuranData("الزلزلة"));
        listquraan.add(new QuranData("العاديات"));
        listquraan.add(new QuranData("القارعة"));
        listquraan.add(new QuranData("التكاثر"));
        listquraan.add(new QuranData("العصر"));
        listquraan.add(new QuranData("الهمزة"));
        listquraan.add(new QuranData("الفيل"));
        listquraan.add(new QuranData("قريش"));
        listquraan.add(new QuranData("الماعون"));
        listquraan.add(new QuranData("الكوثر"));
        listquraan.add(new QuranData("الكافرون"));
        listquraan.add(new QuranData("النصر"));
        listquraan.add(new QuranData("المسد"));
        listquraan.add(new QuranData("الإخلاص"));
        listquraan.add(new QuranData("الفلق"));
        listquraan.add(new QuranData("النّاس"));



















        //  listquraan = Arrays.asList(getResources().getStringArray(R.array.android_v));


      /*  qurrecyclerview = qurrecyclerview.findViewById(R.id.recyclerquran);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        qurrecyclerview.setLayoutManager(layoutManager);


        qurrecyclerview.setHasFixedSize(true);
        qurrecyclerview.setAdapter(adapter);*/
    }
}
