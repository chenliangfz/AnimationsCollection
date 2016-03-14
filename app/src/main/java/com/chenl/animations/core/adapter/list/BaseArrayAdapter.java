package com.chenl.animations.core.adapter.list;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by chenliang19 on 2016/3/14.
 */
public abstract class BaseArrayAdapter<T> extends BaseAdapter implements List<T> {

    private boolean mNotifyOnChange = true;

    private List<T> mObjects;

    public BaseArrayAdapter(){
        mObjects = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public T getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void add(int location, T object) {
        synchronized (mObjects) {
            mObjects.add(location, object);
        }
        notifyDataSetChanged();
    }

    @Override
    public boolean add(T object) {
        boolean isSuccess;
        synchronized (mObjects) {
            isSuccess = mObjects.add(object);
        }
        notifyDataSetChanged(isSuccess);
        return isSuccess;
    }

    @Override
    public boolean addAll(int location, Collection<? extends T> collection) {
        boolean isSuccess;
        synchronized (mObjects) {
            isSuccess = mObjects.addAll(location, collection);
        }
        notifyDataSetChanged(isSuccess);
        return isSuccess;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isSuccess;
        synchronized (mObjects) {
            isSuccess = mObjects.addAll(collection);
        }
        notifyDataSetChanged(isSuccess);
        return isSuccess;
    }

    @Override
    public void clear() {
        synchronized (mObjects) {
            mObjects.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public boolean contains(Object object) {
        return mObjects.contains(object);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return mObjects.containsAll(collection);
    }

    @Override
    public T get(int location) {
        return mObjects.get(location);
    }

    @Override
    public int indexOf(Object object) {
        return mObjects.indexOf(object);
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return mObjects.iterator();
    }

    @Override
    public int lastIndexOf(Object object) {
        return mObjects.lastIndexOf(object);
    }

    @Override
    public ListIterator<T> listIterator() {
        return mObjects.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator(int location) {
        return mObjects.listIterator(location);
    }

    @Override
    public T remove(int location) {
        T object;
        synchronized (mObjects) {
            object = mObjects.remove(location);
            notifyDataSetChanged();
        }
        return object;
    }

    @Override
    public boolean remove(Object object) {
        boolean isSuccess;
        synchronized (mObjects) {
            isSuccess = mObjects.remove(object);
        }
        notifyDataSetChanged(isSuccess);
        return isSuccess;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isSuccess;
        synchronized (mObjects) {
            isSuccess = mObjects.removeAll(collection);
        }
        notifyDataSetChanged(isSuccess);
        return isSuccess;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return mObjects.retainAll(collection);
    }

    @Override
    public T set(int location, T t) {
        T object;
        synchronized (mObjects) {
            object = mObjects.set(location, t);
        }
        notifyDataSetChanged();
        return object;
    }

    @Override
    public int size() {
        return mObjects.size();
    }

    @NonNull
    @Override
    public List<T> subList(int start, int end) {
        return mObjects.subList(start,end);
    }

    @NonNull
    @Override
    public T[] toArray() {
        return (T[]) mObjects.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(T[] array) {
        return mObjects.toArray(array);
    }

    @Override
    public void notifyDataSetChanged() {
        notifyDataSetChanged(true);
    }

    public void notifyDataSetChanged(boolean isSuccess) {
        synchronized (mObjects) {
            if (isSuccess && mNotifyOnChange) {
                super.notifyDataSetChanged();
            }
        }
    }
}
