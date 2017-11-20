package com.zibuyuqing.whale.model;

import com.inmobi.ads.InMobiNative;
import com.zibuyuqing.whale.base.BaseModel;
import com.zibuyuqing.whale.bean.FeedItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class NewsModel implements BaseModel{
    private static FeedItem[] mSampleFeedItems = new FeedItem[5];
    static {
        mSampleFeedItems[0] = new FeedItem("Neha Jha", "Product Manager", "1:50 AM", "Looking out for a Sponsorship Manager with 5+ yrs exp for a sports tourism company in Bangalore with strong grasp of media planning principles & excellent understanding of target segment, market intelligence and media medium technicalities. For more infos contact me at neha@zyoin.com", "neha_jha", "neha_jha_big");
        mSampleFeedItems[1] = new FeedItem("Nazia Firdose", "HR", "9:50 AM", "Please pray for these children in Syria after the death of their mother. The oldest sister has to take care of her younger siblings. -Ayad L Gorgees. ***Please don't scroll past without Typing Amen! because they need our prayers!!", "nazia", "nazia_big");
        mSampleFeedItems[2] = new FeedItem("Dharmesh Shah", "Founder at HubSpot", "4:50 PM", "Why, dear God, haven't you started marketing yet? http://dharme.sh/1Ewu63k by @gjain via @Inboundorg", "dharmesh", "dharmesh_big");
        mSampleFeedItems[3] = new FeedItem("Piyush Shah", "CPO", "6:50 PM", "With mobile being accepted as the definitive medium to access consumers’ minds and wallets, Brands have begun a multi-million dollar spending race to allure and retain customers.  Read on: https://lnkd.in/e8mcUfc", "piyush", "piyush_big");
        mSampleFeedItems[4] = new FeedItem("Jeff Weiner", "CEO at Linkedin", "4:10 AM", "Honored to represent LinkedIn's Economic Graph capabilities at the White House earlier today and partnering to Upskill America.", "jeff", "jeff_big");
    }
    public NewsModel(){

    };
    public Observable<ArrayList<FeedItem>> loadFeedData() {
        return Observable.create(new ObservableOnSubscribe<ArrayList<FeedItem>>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<ArrayList<FeedItem>> e) throws Exception {
                e.onNext(generateFeedItems(20));
                e.onComplete();
            }
        });
    }
    public static ArrayList<FeedItem> generateFeedItems(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("generateFeedItems - Invalid count:" + count);
        }
        final ArrayList<FeedItem> feedItems = new ArrayList<>(count);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            feedItems.add(mSampleFeedItems[random.nextInt(mSampleFeedItems.length)]);
        }
        return feedItems;
    }
}
