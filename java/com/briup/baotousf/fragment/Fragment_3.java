package com.briup.baotousf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.briup.baotousf.LogActivity;
import com.briup.baotousf.R;

public class Fragment_3 extends Fragment {
    public View view;
    public TextView cust_name;

    public ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_3,null);

        img=view.findViewById(R.id.f3_dl);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Fragment_3.this.getContext(), LogActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
