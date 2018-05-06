package com.example.ahmedx64.recyclerview.MyBase;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by ahmed x64 on 4/15/2018.
 */

public class MyBaseFragment extends Fragment {

    protected MyBaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity=(MyBaseActivity)context;

    }

    public void ShowMessage(String title, String mssg){
        activity.ShowMessage(title,mssg);
    }

}
