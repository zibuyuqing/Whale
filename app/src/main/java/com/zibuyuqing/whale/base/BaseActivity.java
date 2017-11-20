package com.zibuyuqing.whale.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.inmobi.sdk.InMobiSdk;
import com.zibuyuqing.whale.Config;

import butterknife.ButterKnife;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        initInMobiSdk();
        init();
    }
    private void initInMobiSdk(){
        InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
        InMobiSdk.init(this, Config.INMOBI_ACCOUNT_ID);
    }
    protected abstract int layoutId();
    protected abstract void init();
}
