package com.zibuyuqing.whale.bean;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */


public class FeedItem {
    private String title;
    private String subtitle;
    private String timestamp;
    private String description;
    private String thumbImage;
    private String bigImage;

    public FeedItem(String title, String subtitle, String time_tt, String description_tt, String thumb_image, String big_image) {
        this.title = title;
        this.subtitle = subtitle;
        this.timestamp = time_tt;
        this.description = description_tt;
        this.thumbImage = thumb_image;
        this.bigImage = big_image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public String getBigImage() {
        return bigImage;
    }
}
