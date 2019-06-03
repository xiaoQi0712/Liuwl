package com.briup.baotousf.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.briup.baotousf.R;

public class HometwoActivity extends AppCompatActivity {
    public ImageView tz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hometwo);

        tz = findViewById(R.id.hometwo_fh);
        tz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
