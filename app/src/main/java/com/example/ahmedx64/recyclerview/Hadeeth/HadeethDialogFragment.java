package com.example.ahmedx64.recyclerview.Hadeeth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ahmedx64.recyclerview.R;


/**
 * Created by ahmed x64 on 4/14/2018.
 */

public class HadeethDialogFragment extends android.support.v4.app.DialogFragment {

    View v;
    HadeethData hadeethData;

    public void setHadeethData(HadeethData hadeethData) {
        this.hadeethData = hadeethData;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dialog_hadeeth,container,false);
        TextView textView = (TextView) v.findViewById(R.id.hadeetdialog_text);
        final Button bott = v.findViewById(R.id.button);
        textView.setText(hadeethData.gethadethcontent());
        bott.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return v;
    }
}
