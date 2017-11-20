package com.zibuyuqing.whale;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.inmobi.sdk.InMobiSdk;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class MyApp extends Application {
    private static MyApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static MyApp getInstance(){
        return instance;
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
