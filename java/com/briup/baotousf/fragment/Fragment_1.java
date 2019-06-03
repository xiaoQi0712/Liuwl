package com.briup.baotousf.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.briup.baotousf.Home.HomefourActivity;
import com.briup.baotousf.Home.HomeoneActivity;
import com.briup.baotousf.Home.HomethreeActivity;
import com.briup.baotousf.Home.HometwoActivity;
import com.briup.baotousf.Adapter.LunBoAdapter;
import com.briup.baotousf.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Fragment_1 extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener{
    public View view;

    public LinearLayout tz1;
    public LinearLayout tz2;
    public LinearLayout tz3;
    public LinearLayout tz4;

    public static final int VIEW_PAGER_DELAY = 3000;
    private LunBoAdapter Adapter;
    private List<ImageView> Items;
    private ImageView[] BottomImages;
    private LinearLayout BottomLiner;
    private ViewPager ViewPager;

    private int currentViewPagerItem;
    //是否自动播放
    private boolean isAutoPlay;

    private MyHandler Handler;
    private Thread Thread;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_1,null);

        tz1=view.findViewById(R.id.homeone_dj);
        tz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Fragment_1.this.getContext(), HomeoneActivity.class);
                startActivity(intent);
            }
        });
        tz2=view.findViewById(R.id.hometwo_dj);
        tz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Fragment_1.this.getContext(), HometwoActivity.class);
                startActivity(intent);
            }
        });
        tz3=view.findViewById(R.id.homethree_dj);
        tz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Fragment_1.this.getContext(), HomethreeActivity.class);
                startActivity(intent);
            }
        });
        tz4=view.findViewById(R.id.homefour_dj);
        tz4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Fragment_1.this.getContext(), HomefourActivity.class);
                startActivity(intent);
            }
        });

        Handler = new MyHandler(this);
        //配置轮播图ViewPager
        ViewPager = ((ViewPager) view.findViewById(R.id.live_view_pager));
        Items = new ArrayList<>();
        Adapter = new LunBoAdapter(Items,getContext());
        ViewPager.setAdapter(Adapter);
        ViewPager.setOnTouchListener(this);
        ViewPager.addOnPageChangeListener(this);
        isAutoPlay = true;

        //TODO: 添加ImageView
        addImageView();
        Adapter.notifyDataSetChanged();
        //设置底部4个小点
        setBottomIndicator();
        return view;

    }
    private void addImageView(){
        ImageView view0 = new ImageView(this.getActivity());
        view0.setImageResource(R.mipmap.lunbo1);
        ImageView view1 = new ImageView(this.getActivity());
        view1.setImageResource(R.mipmap.oneone);
        ImageView view2 = new ImageView(this.getActivity());
        view2.setImageResource(R.mipmap.lunbo2);
        ImageView view3 = new ImageView(this.getActivity());
        view3.setImageResource(R.mipmap.lunbo3);
        ImageView view4 = new ImageView(this.getActivity());
        view4.setImageResource(R.mipmap.lunbo4);
        ImageView view5 = new ImageView(this.getActivity());
        view5.setImageResource(R.mipmap.lunbo5);

        view0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view4.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view5.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Items.add(view0);
        Items.add(view1);
        Items.add(view2);
        Items.add(view3);
        Items.add(view4);
        Items.add(view5);

    }

    private void setBottomIndicator() {
        //获取指示器(下面三个小点)
        BottomLiner = (LinearLayout) view.findViewById(R.id.live_indicator);
        //右下方小圆点
        BottomImages = new ImageView[Items.size()];
        for (int i = 0; i < BottomImages.length; i++) {
            ImageView imageView = new ImageView(this.getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(5, 0, 5, 0);
            imageView.setLayoutParams(params);
            //如果当前是第一个 设置为选中状态
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_select);
            } else {
                imageView.setImageResource(R.drawable.indicator_no_select);
            }
            BottomImages[i] = imageView;
            //添加到父容器
            BottomLiner.addView(imageView);
        }

        //让其在最大值的中间开始滑动, 一定要在 mBottomImages初始化之前完成
        int mid = LunBoAdapter.MAX_SCROLL_VALUE / 2;
        ViewPager.setCurrentItem(mid);
        currentViewPagerItem = mid;

        //定时发送消息
        Thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true) {
                    Handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(Fragment_1.VIEW_PAGER_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Thread.start();
    }
    // ViewPager的监听事件
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        currentViewPagerItem = position;
        if (Items != null) {
            position %= BottomImages.length;
            int total = BottomImages.length;

            for (int i = 0; i < total; i++) {
                if (i == position) {
                    BottomImages[i].setImageResource(R.drawable.indicator_select);
                } else {
                    BottomImages[i].setImageResource(R.drawable.indicator_no_select);
                }
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                isAutoPlay = false;
                break;
            case MotionEvent.ACTION_UP:
                isAutoPlay = true;
                break;
        }
        return false;
    }
    // 为防止内存泄漏, 声明自己的Handler并弱引用Activity
    private static class MyHandler extends android.os.Handler {
        private WeakReference<Fragment_1> mWeakReference;

        public MyHandler(Fragment_1 activity) {
            mWeakReference = new WeakReference<Fragment_1>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Fragment_1 activity = mWeakReference.get();
                    if (activity.isAutoPlay) {

                        activity.ViewPager.setCurrentItem(++activity.currentViewPagerItem);
                    }

                    break;
            }

        }
    }
}
