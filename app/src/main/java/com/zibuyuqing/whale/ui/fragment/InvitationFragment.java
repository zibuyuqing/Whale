package com.zibuyuqing.whale.ui.fragment;

import com.zibuyuqing.whale.R;
import com.zibuyuqing.whale.base.BaseFragment;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class InvitationFragment extends BaseFragment {
    @Override
    protected boolean refreshEnable() {
        return false;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_invitation;
    }

    @Override
    protected void init() {

    }

    @Override
    protected String getTitle() {
        return "Invitation";
    }
}
