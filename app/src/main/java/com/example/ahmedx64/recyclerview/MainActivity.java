package com.example.ahmedx64.recyclerview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.ahmedx64.recyclerview.Hadeeth.HadeethFragment;
import com.example.ahmedx64.recyclerview.MyBase.MyBaseActivity;
import com.example.ahmedx64.recyclerview.Quran.QuranFragment;
import com.example.ahmedx64.recyclerview.Radio.infoFragment;

public class MainActivity extends MyBaseActivity {

    public static String actTitle;
    private TabLayout tabLayout;
    private ViewPager viewPager ;
    private ViewAgerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewAgerAdapter(getSupportFragmentManager());
        //add fragment here
        adapter.AddFragment(new QuranFragment(),"القرآن");
        adapter.AddFragment(new HadeethFragment(),"الحديث");
        adapter.AddFragment(new infoFragment(),"استماع ");
      //  adapter.AddFragment(new Aboutus(),"من نحن ");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher_quran1);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher_hadeeth);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher_info);


    }

}
