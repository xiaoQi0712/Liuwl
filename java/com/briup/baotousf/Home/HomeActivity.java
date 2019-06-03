package com.briup.baotousf.Home;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.briup.baotousf.R;
import com.briup.baotousf.fragment.Fragment_1;
import com.briup.baotousf.fragment.Fragment_2;
import com.briup.baotousf.fragment.Fragment_3;

public class HomeActivity extends FragmentActivity implements View.OnClickListener{

    public LinearLayout linerlayout1;
    public LinearLayout linerlayout2;
    public LinearLayout linerlayout3;

    public ImageView ImageView1;
    public ImageView ImageView2;
    public ImageView ImageView3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置状态栏为透明
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_home);

        linerlayout1 = findViewById(R.id.llhomepage);
        linerlayout2 = findViewById(R.id.llindent);
        linerlayout3 = findViewById(R.id.llme);
        linerlayout1.setOnClickListener(this);
        linerlayout2.setOnClickListener(this);
        linerlayout3.setOnClickListener(this);

        ImageView1 = findViewById(R.id.ivhomepage);
        ImageView2 = findViewById(R.id.ivindent);
        ImageView3 = findViewById(R.id.ivme);
        ImageView1.setOnClickListener(this);
        ImageView2.setOnClickListener(this);
        ImageView3.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();    //拿到管理器
        FragmentTransaction beginTransaction = fm.beginTransaction();
        beginTransaction.replace(R.id.framelayout,new Fragment_1());  //开启事物
        ImageView1.setImageResource(R.mipmap.homepage2);
        beginTransaction.commit();  //提交

    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fm.beginTransaction();
        switch (v.getId()) {
            case R.id.llhomepage: //点击的是主页
                beginTransaction.replace(R.id.framelayout, new Fragment_1());
                ImageView1.setImageResource(R.mipmap.homepage2);
                ImageView2.setImageResource(R.mipmap.indent);
                ImageView3.setImageResource(R.mipmap.me);
                break;
            case R.id.llindent: //点击的是订单
                beginTransaction.replace(R.id.framelayout, new Fragment_2());
                ImageView1.setImageResource(R.mipmap.homepage);
                ImageView2.setImageResource(R.mipmap.indent2);
                ImageView3.setImageResource(R.mipmap.me);
                break;
            case R.id.llme: //点击的是我的
                beginTransaction.replace(R.id.framelayout, new Fragment_3());
                ImageView1.setImageResource(R.mipmap.homepage);
                ImageView2.setImageResource(R.mipmap.indent);
                ImageView3.setImageResource(R.mipmap.me2);
                break;
        }
        beginTransaction.commit();
    }


}