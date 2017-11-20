package com.zibuyuqing.whale.utility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ViewGroup;

import com.zibuyuqing.whale.R;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class SwipeRefreshLayoutWrapper {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    public interface Listener {
        boolean canChildScrollUp();
        void onRefresh();
    }
    public static SwipeRefreshLayout getInstance(Context context, final Listener listener){
        final SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(context){
            @Override
            public boolean canChildScrollUp() {
                return listener.canChildScrollUp();
            }
        };
        swipeRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        swipeRefreshLayout.setColorSchemeColors(
                R.color.colorAccent,
                R.color.colorAccentDark,
                R.color.colorPrimary,
                R.color.colorPrimaryDark
        );
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                HANDLER.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onRefresh();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },3000);
            }
        });
        return swipeRefreshLayout;
    }
}
