package com.briup.baotousf.Home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.briup.baotousf.R;
import com.briup.baotousf.fragment.HomeThreeFragment.Fragment_three_1;
import com.briup.baotousf.fragment.HomeThreeFragment.Fragment_three_2;
import com.briup.baotousf.fragment.HomeThreeFragment.Fragment_three_3;

public class HomethreeActivity extends FragmentActivity implements View.OnClickListener{
    public ImageView tz;

    public TextView textview1;
    public TextView textview2;
    public TextView textview3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homethree);

        tz = findViewById(R.id.homethree_fh);
        tz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textview1 = findViewById(R.id.three_tc_1);
        textview2 = findViewById(R.id.three_tc_2);
        textview3 = findViewById(R.id.three_tc_3);
        textview1.setOnClickListener(this);
        textview2.setOnClickListener(this);
        textview3.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();    //拿到管理器
        FragmentTransaction beginTransaction = fm.beginTransaction();
        beginTransaction.replace(R.id.three_framelayout,new Fragment_three_1());  //开启事物
        textview1.setTextColor(Color.parseColor("red"));
        beginTransaction.commit();  //提交
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.three_tc_1: //点击的是9.9
                beginTransaction.replace(R.id.three_framelayout, new Fragment_three_1());
                textview1.setTextColor(Color.parseColor("red"));
                textview2.setTextColor(Color.parseColor("#7A6CB5"));
                textview3.setTextColor(Color.parseColor("#7A6CB5"));
                break;
            case R.id.three_tc_2: //点击的是14.8
                beginTransaction.replace(R.id.three_framelayout, new Fragment_three_2());
                textview1.setTextColor(Color.parseColor("#7A6CB5"));
                textview2.setTextColor(Color.parseColor("red"));
                textview3.setTextColor(Color.parseColor("#7A6CB5"));
                break;
            case R.id.three_tc_3: //点击的是18.8
                beginTransaction.replace(R.id.three_framelayout, new Fragment_three_3());
                textview1.setTextColor(Color.parseColor("#7A6CB5"));
                textview2.setTextColor(Color.parseColor("#7A6CB5"));
                textview3.setTextColor(Color.parseColor("red"));
                break;
        }
        beginTransaction.commit();

    }
}
