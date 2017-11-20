package com.zibuyuqing.whale.base;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
    void detachView();
}
