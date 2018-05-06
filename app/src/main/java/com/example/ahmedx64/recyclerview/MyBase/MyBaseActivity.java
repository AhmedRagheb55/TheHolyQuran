package com.example.ahmedx64.recyclerview.MyBase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ahmedx64.recyclerview.R;

/**
 * Created by ahmed x64 on 4/15/2018.
 */

public class MyBaseActivity extends AppCompatActivity {

    MyBaseActivity activity;
    MaterialDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }

    public MaterialDialog ShowProgressDialoge() {

        if (dialog == null || !dialog.isShowing())
            dialog = new MaterialDialog.Builder(this)
                    .title(R.string.loading)
                    .content(R.string.please_wait)
                    .progress(true, 0)
                    .cancelable(true)
                    .show();

        else return dialog;

        return dialog;
    }

    public void HideProgressDialog() {

        if (dialog != null && dialog.isShowing()) dialog.dismiss();

    }

    public MaterialDialog ShowMessage(String title, String mess) {

        dialog = new MaterialDialog.Builder(this)
                //.title(R.string.error_login)
                .content(mess)
                .positiveText(R.string.ok)
                .show();
        return dialog;
    }

    public MaterialDialog ShowConfirmationDialog(String title, String mess, String posText, String negText, MaterialDialog.SingleButtonCallback onPositiveClick) {

        dialog = new MaterialDialog.Builder(this)
                // .title(R.string.error_login)
                .content(mess)
                .positiveText(posText)
                .negativeText(negText)
                .onPositive(onPositiveClick)
                .show();

        return dialog;


    }
}
