package com.briup.baotousf;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.briup.baotousf.Home.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

// ui线程
public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    private int recLen = 5;//跳过倒计时提示5秒
    private TextView tv;
    Timer timer = new Timer();  //定义一个计时器
    private Handler handler;  //Handler是用来结合线程的消息队列来发送、处理“Runnable对象”的工具
    private Runnable runnable;   //多线程 接口
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
        setContentView(R.layout.activity_welcome);
        initView();
        timer.schedule(task,1000,1000);//停顿时间一秒
        /**
         * 正常情况下不点击跳过
         */
        handler = new Handler();
        handler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                //从欢迎界面跳转到主界面
                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
         },5000);//延迟5S后发送handler信息

    }

     private void initView() {
        tv = findViewById(R.id.tv);//跳过
         tv.setOnClickListener(this);//跳过监听
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    recLen--;
                    tv.setText(recLen+"s跳过");
                    if (recLen < 0){
                        timer.cancel();
                        tv.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        };
    };
    /**
     * 点击跳过
     */
     @Override
     public void onClick(View view) {
         switch (view.getId()) {
             case R.id.tv:
                 //从欢迎界面跳转到主界面
                 Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                 startActivity(intent);
                 finish();
                 if (runnable != null) {
                     handler.removeCallbacks(runnable);
                 }
                 break;
             default:
                 break;
         }
     }
}

