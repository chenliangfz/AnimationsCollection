package com.chenl.animations.core.adapter.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenliang19 on 2016/3/14.
 */
public abstract class ViewArrayAdapter<T, V extends View> extends BaseArrayAdapter<T> {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        V view;
        if (convertView == null) {
            view = createView(parent.getContext());
        } else {
            view = (V)convertView;
        }
        bindView(position, view, getItem(position));
        return view;
    }

    protected abstract V createView(Context context);

    protected abstract void bindView(int position, V view, T item);
}
