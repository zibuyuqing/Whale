package com.zibuyuqing.whale.view;

import com.zibuyuqing.whale.base.BaseView;
import com.zibuyuqing.whale.bean.AdFeedItem;
import com.zibuyuqing.whale.bean.FeedItem;

import java.util.ArrayList;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public interface HomeView extends BaseView {
    void refreshFeedData(ArrayList<FeedItem> feedData);
    void refreshAd(int position, AdFeedItem adFeedItem);
}
