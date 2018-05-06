package com.example.ahmedx64.recyclerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed x64 on 4/8/2018.
 */

public class ViewAgerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listfragment = new ArrayList<>();
    private final  List<String> listtitles = new ArrayList<>();

    public ViewAgerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listfragment.get(position);
    }

    @Override
    public int getCount() {
        return listtitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
         return listtitles.get(position);
    }


    public void AddFragment (Fragment fragment , String titles){

        listfragment.add(fragment);
        listtitles.add(titles);
    }

}
