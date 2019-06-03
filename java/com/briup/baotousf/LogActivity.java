package com.briup.baotousf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.briup.baotousf.Home.HomeActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogActivity extends AppCompatActivity implements View.OnClickListener{
    public ImageView img;
    public TextView tv;

    public EditText log_phone;
    public EditText log_password;
    public Button log_dl;
    public String phone;
    public String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        img = findViewById(R.id.log_fh);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        tv = findViewById(R.id.log_zc);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LogActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });

        initView();
    }

    private void initView(){
        log_phone = findViewById(R.id.log_phone);
        log_password = findViewById(R.id.log_password);
        log_dl = findViewById(R.id.log_dl);


        log_dl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.log_dl:
                login();
                break;
        }
    }
    private void login(){
        phone = log_phone.getText().toString().trim();
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        password = log_password.getText().toString().trim();
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        //网络请求是耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                final boolean flag = getRequestGetLogin();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("aaa",flag+"");
                        if (flag){
                            Toast.makeText(LogActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LogActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LogActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();

        // TODO validate success, do something
    }

    private boolean getRequestGetLogin() {
        try {
            Log.i("aaa",phone+":"+password);
            URL url = new URL("http://192.168.43.28:8888/BtsfXm/cust/login?cust_phone=" + phone + "&cust_password=" + password);
            //进行网络连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //设置请求方式
            connection.setRequestMethod("POST");
            //设置超时时间
            connection.setConnectTimeout(10*1000);
            //获取响应码
            int code = connection.getResponseCode();
            Log.i("aaa",code+"");
            if (200 == code){
                InputStream inputStream = connection.getInputStream();

                BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream));
                String line = reader.readLine();
                Log.i("aaa",line);
                if(TextUtils.isEmpty(line)){
                    return false;
                }else {
                    if (line.contains("succes")){
                        return true;
                    }else {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
