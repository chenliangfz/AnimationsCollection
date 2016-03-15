package com.chenl.animations.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.chenl.animations.R;
import com.chenl.animations.core.BaseFragment;
import com.chenl.animations.core.adapter.pager.BaseFragmentStatePagerAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by Chen,L on 2016/3/15.
 */
@EFragment(R.layout.layout_pager)
public class HorizontalPagerFragment extends BaseFragment {

    @ViewById(R.id.pager)
    ViewPager mViewPager;

    PagerFragmentAdapter mAdapter;

    @AfterViews
    void afterViews(){
        mAdapter = new PagerFragmentAdapter(getChildFragmentManager(),createFragments());
        mViewPager.setAdapter(mAdapter);
    }

    private List<Fragment> createFragments() {
        return null;
    }


    private class PagerFragmentAdapter extends BaseFragmentStatePagerAdapter<Fragment>{

        public PagerFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            addAll(fragments);
        }
    }
}
