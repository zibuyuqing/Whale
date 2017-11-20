package com.zibuyuqing.whale.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zibuyuqing.whale.R;
import com.zibuyuqing.whale.adapter.FeedAdapter;
import com.zibuyuqing.whale.base.BaseFragment;
import com.zibuyuqing.whale.bean.AdFeedItem;
import com.zibuyuqing.whale.bean.FeedItem;
import com.zibuyuqing.whale.present.HomePresenter;
import com.zibuyuqing.whale.view.HomeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class HomeFragment extends BaseFragment implements HomeView {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private static final String TAG = HomeFragment.class.getSimpleName();
    private RecyclerView.Adapter mFeedAdapter;
    private ArrayList<FeedItem> mFeedItems = new ArrayList<>();
    private Map<Integer, FeedItem> mFeedMap = new HashMap<>();
    private HomePresenter mPresenter;
    @Override
    protected boolean refreshEnable() {
        return true;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mPresenter = new HomePresenter(getActivity());
        mPresenter.attachView(this);
        mPresenter.loadFeedData();
        mPresenter.loadNativeAds();
        mFeedAdapter = new FeedAdapter(mFeedItems, getActivity());
        Log.e(TAG,"init");
        mRecyclerView.setAdapter(mFeedAdapter);
    }

    @Override
    protected String getTitle() {
        return "Home";
    }

    @Override
    public void onDestroyView() {
        if(mPresenter != null){
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void showDialog() {
        showTips("加载....");
    }

    @Override
    public void hideDialog() {
        showTips("加载完成....");
    }

    @Override
    public void showMsg(String msg) {
        showTips(msg);
    }

    @Override
    public void refreshFeedData(ArrayList<FeedItem> feedData) {
        showTips("refreshFeedData....");
        mFeedItems.addAll(feedData);
        mFeedAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshAd(int position, AdFeedItem adFeedItem) {
        mFeedItems.add(position, adFeedItem);
        mFeedAdapter.notifyItemChanged(position);
    }

}
