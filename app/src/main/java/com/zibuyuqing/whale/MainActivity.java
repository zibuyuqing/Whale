package com.zibuyuqing.whale;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.sdk.InMobiSdk;
import com.zibuyuqing.whale.adapter.FragmentAdapter;
import com.zibuyuqing.whale.base.BaseActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    public static final String TAG = "AppCompatActivity";
    @BindView(R.id.vpContent)
    ViewPager vpContent;
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        final FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        vpContent.setAdapter(adapter);
    }
}
