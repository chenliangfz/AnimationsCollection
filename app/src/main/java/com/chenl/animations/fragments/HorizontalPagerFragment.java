package com.chenl.animations.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.chenl.animations.R;
import com.chenl.animations.core.BaseFragment;
import com.chenl.animations.core.adapter.pager.BaseFragmentStatePagerAdapter;
import com.chenl.animations.utils.L;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen,L on 2016/3/15.
 */
@EFragment(R.layout.layout_pager)
public class HorizontalPagerFragment extends BaseFragment {

    @ViewById(R.id.pager)
    ViewPager mViewPager;

    PagerFragmentAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @AfterViews
    void afterViews(){
        mAdapter = new PagerFragmentAdapter(getChildFragmentManager(),createFragments());
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        L.e("HorizontalPagerFragment_onCreateContextMenu");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        L.e("HorizontalPagerFragment_onCreateOptionsMenu");
        super.onCreateOptionsMenu(menu, inflater);
        menu.add("HorizontalPagerFragment");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        L.e("HorizontalPagerFragment_onPrepareOptionsMenu");
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        L.e("HorizontalPagerFragment_onOptionsMenuClosed");
        super.onOptionsMenuClosed(menu);
    }

    private List<Fragment> createFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            fragments.add(PageFragment_.builder().arg(PageFragment.POSITION_BUNDLE,i).build());
        }
        return fragments;
    }


    private class PagerFragmentAdapter extends BaseFragmentStatePagerAdapter<Fragment>{

        public PagerFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            addAll(fragments);
        }
    }
}
