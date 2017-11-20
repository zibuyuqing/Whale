package com.zibuyuqing.whale.present;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.zibuyuqing.whale.Config;
import com.zibuyuqing.whale.base.BasePresenter;
import com.zibuyuqing.whale.bean.AdFeedItem;
import com.zibuyuqing.whale.bean.FeedItem;
import com.zibuyuqing.whale.model.NewsModel;
import com.zibuyuqing.whale.view.HomeView;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class HomePresenter implements BasePresenter<HomeView> {
    HomeView view;
    NewsModel model = new NewsModel();
    private Activity activity;
    private int[] adPositions = new int[]{3, 8, 18};
    private ArrayList<InMobiNative> strands = new ArrayList<>();
    private String TAG ="NativeAdsPresenter";

    public HomePresenter(Activity activity){
        this.activity = activity;
        for (int position : adPositions) {
            final InMobiNative nativeStrand = new InMobiNative(activity,
                    Config.INMOBI_IN_STREAM_AD_ID, new StrandAdListener(position));
            strands.add(nativeStrand);
        }
    }
    public ArrayList<InMobiNative> loadNativeAds(){
        Log.e(TAG,"loadNativeAds");
        for(InMobiNative mobiNative : strands){
            mobiNative.load();
        }
        return strands;
    }
    public void loadFeedData(){
        view.showDialog();
        Log.e(TAG,"loadFeedData");
        model.loadFeedData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<FeedItem>>() {
                    @Override
                    public void accept(ArrayList<FeedItem> feedItems) throws Exception {
                        view.hideDialog();
                        view.refreshFeedData(feedItems);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.hideDialog();
                        view.showMsg(throwable.getMessage());
                    }
                });
    }
    @Override
    public void attachView(HomeView view) {
        Log.e(TAG,"attachView");
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
    class StrandAdListener implements InMobiNative.NativeAdListener{
        private int position;
        public StrandAdListener (int position){
            this.position = position;
        }
        @Override
        public void onAdLoadSucceeded(@NonNull InMobiNative inMobiNative) {
            view.refreshAd(position,new AdFeedItem(inMobiNative));
        }

        @Override
        public void onAdLoadFailed(@NonNull InMobiNative inMobiNative, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
            view.showMsg("position :" + position + ",message=:" + inMobiAdRequestStatus.getMessage());
        }

        @Override
        public void onAdFullScreenDismissed(InMobiNative inMobiNative) {

        }

        @Override
        public void onAdFullScreenWillDisplay(InMobiNative inMobiNative) {

        }

        @Override
        public void onAdFullScreenDisplayed(InMobiNative inMobiNative) {

        }

        @Override
        public void onUserWillLeaveApplication(InMobiNative inMobiNative) {

        }

        @Override
        public void onAdImpressed(@NonNull InMobiNative inMobiNative) {

        }

        @Override
        public void onAdClicked(@NonNull InMobiNative inMobiNative) {

        }

        @Override
        public void onMediaPlaybackComplete(@NonNull InMobiNative inMobiNative) {

        }

        @Override
        public void onAdStatusChanged(@NonNull InMobiNative inMobiNative) {

        }
    }
}
