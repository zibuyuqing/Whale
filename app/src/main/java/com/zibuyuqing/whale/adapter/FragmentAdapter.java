package com.zibuyuqing.whale.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zibuyuqing.whale.ui.fragment.HomeFragment;
import com.zibuyuqing.whale.ui.fragment.InvitationFragment;
import com.zibuyuqing.whale.ui.fragment.MeFragment;

/**
 * Created by Xijun.Wang on 2017/11/20.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter{
    private static final int NUM_TABS = 3;

    private static final int POSITION_HOME_INTEGRATION = 0;

    private static final int POSITION_INVITATION_INTEGRATION = 1;

    private static final int POSITION_ME_INTEGRATION = 2;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case POSITION_HOME_INTEGRATION:
                return new HomeFragment();

            case POSITION_INVITATION_INTEGRATION:
                return new InvitationFragment();

            case POSITION_ME_INTEGRATION:
                return new MeFragment();

            default:
                throw new IllegalArgumentException("No fragment for position:" + position);
        }
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }
}
