package com.zibuyuqing.whale.ui.fragment;

import com.zibuyuqing.whale.R;
import com.zibuyuqing.whale.base.BaseFragment;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class MeFragment extends BaseFragment {
    @Override
    protected boolean refreshEnable() {
        return true;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init() {

    }

    @Override
    protected String getTitle() {
        return "Me";
    }
}
