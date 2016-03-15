package com.chenl.animations.core.adapter.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenliang19 on 2016/2/26.
 */
public class BaseFragmentStatePagerAdapter<F extends Fragment> extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mFragments;

    public BaseFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public void addAll(List<F> fragments){
        mFragments.addAll(fragments);
    }

    public static class FragmentInfo {
        public String fragmentClassName;
        public String tag;
    }
}
