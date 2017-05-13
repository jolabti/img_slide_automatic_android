package com.apps.alter.imageslideapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        //Calling Timmer

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mViewPager.getCurrentItem() == 0) {
                        mViewPager.setCurrentItem(1);
                    } else if (mViewPager.getCurrentItem() == 1) {
                        mViewPager.setCurrentItem(2);
                    } else if (mViewPager.getCurrentItem() == 2) {
                        mViewPager.setCurrentItem(3);
                    } else if (mViewPager.getCurrentItem() == 3) {
                        mViewPager.setCurrentItem(4);
                    } else if (mViewPager.getCurrentItem() == 4) {
                        mViewPager.setCurrentItem(5);
                    }
                }
            });


        }
    }

}
