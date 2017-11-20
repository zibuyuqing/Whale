package com.zibuyuqing.whale.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.ViewStubCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zibuyuqing.whale.utility.SwipeRefreshLayoutWrapper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public abstract class BaseFragment extends Fragment{
    private static final String TAG = BaseFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(layoutId(),container,false);
        if(refreshEnable()){
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayoutWrapper.
                    getInstance(getContext(), new SwipeRefreshLayoutWrapper.Listener() {
                @Override
                public boolean canChildScrollUp() {
                    return canViewScrollUp();
                }

                @Override
                public void onRefresh() {
                    refresh();
                }
            });
            swipeRefreshLayout.addView(view,
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ButterKnife.bind(this, swipeRefreshLayout);
            init();
            return swipeRefreshLayout;
        } else {
            ButterKnife.bind(this, view);
            init();
        }
        return view;
    }
    protected boolean canViewScrollUp(){
        return false;
    }
    protected abstract boolean refreshEnable();
    protected abstract int layoutId();
    protected abstract void init();
    protected abstract String getTitle();
    protected void refresh(){
        if(!refreshEnable()){
            return;
        }
    }
    public void showTips(String msg){
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

}
