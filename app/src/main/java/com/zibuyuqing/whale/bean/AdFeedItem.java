package com.zibuyuqing.whale.bean;

import com.inmobi.ads.InMobiNative;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */
/**
 {
 "title": "title",
 "description": "description",
 "icon": "icon",
 "landingURL": "LandingUrl",
 "cta": "cta",
 "rating": "rating"
 }
 */
public class AdFeedItem extends FeedItem {
    public InMobiNative mNativeStrand;
    public AdFeedItem(InMobiNative nativeStrand) {
        super("", "", "", "", "", "");
        mNativeStrand = nativeStrand;
    }
}
