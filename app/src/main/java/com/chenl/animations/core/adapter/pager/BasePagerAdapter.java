package com.chenl.animations.core.adapter.pager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenliang19 on 2016/2/26.
 */
public abstract class BasePagerAdapter<T> extends PagerAdapter {

    protected List<T> mData;

    private List<View> mRecycleViews;

    public BasePagerAdapter() {
        mData = new ArrayList<T>();
        mRecycleViews = new LinkedList<View>();
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    public T getItem(int position) {
        return (mData != null && !mData.isEmpty()) ? mData.get(position) : null;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public abstract View instantiateView(ViewGroup container);

    public abstract void bindView(T t, View view, int position);

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = null;
        if (mRecycleViews.size() == 0) {
            view = instantiateView(container);
        } else {
            view = mRecycleViews.remove(0);
        }
        bindView(getItem(position), view, position);
        if (view != null) {
            container.addView(view);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
        mRecycleViews.add((View) object);
    }

    public void append(List<T> items) {
        if (items != null && !items.isEmpty()) {
            mData.addAll(items);
            notifyDataSetChanged();
        }
    }

    public void add(T item) {
        if (item != null) {
            mData.add(item);
            notifyDataSetChanged();
        }
    }

    public void remove(T item) {
        if (item != null) {
            mData.remove(item);
            notifyDataSetChanged();
        }
    }

    public void remove(int position) {
        mData.remove(position);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    public void setData(List<T> items) {
        if (items != null && !items.isEmpty()) {
            mData = items;
            notifyDataSetChanged();
        }
    }
}
