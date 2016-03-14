package com.chenl.animations.core.adapter.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by chenliang19 on 2016/2/26.
 */
public class BaseFragmentStatePagerAdapter<F extends Fragment> extends FragmentStatePagerAdapter {
    private ArrayList<FragmentInfo> mFragmentInfos = new ArrayList<>();

    public BaseFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return mFragmentInfos.size();
    }

    public static class FragmentInfo {
        public String fragmentClassName;
        public String tag;
    }
}
