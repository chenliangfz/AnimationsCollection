package com.chenl.animations.core.adapter.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenliang19 on 2016/2/29.
 */
public abstract class ViewRecyclerAdapter<T, V extends View> extends BaseRecyclerAdapter<T, ViewRecyclerAdapter.RecyclerHolder<V>> {
    @Override
    public ViewRecyclerAdapter.RecyclerHolder<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewRecyclerAdapter.RecyclerHolder<V>(createView(parent.getContext(), viewType)) {
        };
    }

    @Override
    public void onBindViewHolder(ViewRecyclerAdapter.RecyclerHolder<V> holder, int position) {
        bindView(position, holder.mView, get(position));
    }

    protected abstract V createView(Context context, int viewType);

    protected abstract void bindView(int position, V view, T object);

    public static class RecyclerHolder<V extends View> extends RecyclerView.ViewHolder {

        public V mView;

        public RecyclerHolder(V itemView) {
            super(itemView);
            mView = itemView;
        }
    }
}
