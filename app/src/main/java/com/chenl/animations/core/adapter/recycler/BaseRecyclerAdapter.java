package com.chenl.animations.core.adapter.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by chenliang19 on 2016/2/29.
 */
public abstract class BaseRecyclerAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements List<T> {

    private ArrayList<T> mObjects = new ArrayList<>();

    @Override
    public int getItemCount() {
        return size();
    }

    @Override
    public void add(int location, T object) {
        synchronized (mObjects) {
            mObjects.add(location, object);
            notifyItemChanged(location);
        }
    }

    @Override
    public boolean add(T object) {
        boolean isSuccess;
        synchronized (mObjects) {
            isSuccess = mObjects.add(object);
            if (isSuccess) {
                notifyItemRangeInserted(indexOf(object), 1);
            }
        }
        return isSuccess;
    }

    @Override
    public boolean addAll(int location, Collection<? extends T> collection) {
        boolean isSuccess = false;
        if (collection!=null && !collection.isEmpty()) {
            synchronized (mObjects) {
                isSuccess = mObjects.addAll(location, collection);
                if (isSuccess) {
                    notifyItemRangeInserted(location, collection.size());
                }
            }
        }
        return isSuccess;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isSuccess = false;
        if (collection!=null && !collection.isEmpty()) {
            synchronized (mObjects) {
                int location = size()-1;
                isSuccess = mObjects.addAll(collection);
                notifyItemRangeInserted(Math.max(0, location), collection.size());
            }
        }
        return isSuccess;
    }

    @Override
    public void clear() {
        synchronized (mObjects) {
            mObjects.clear();
            notifyItemRangeRemoved(0,size());
        }
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

    @Override
    public boolean isEmpty() {
        return mObjects.isEmpty();
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
            notifyItemRemoved(location);
        }
        return object;
    }

    @Override
    public boolean remove(Object object) {
        boolean isSuccess;
        synchronized (mObjects) {
            int location = indexOf(object);
            isSuccess = mObjects.remove(object);
            notifyItemRemoved(location);
        }
        return isSuccess;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isSuccess = false;
        if (collection!=null && !collection.isEmpty()) {
            synchronized (mObjects) {
                int location = size()-1;
                isSuccess = mObjects.removeAll(collection);
                if (isSuccess) {
                    notifyItemRangeRemoved(location, collection.size());
                }
            }
        }
        return isSuccess;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return mObjects.retainAll(collection);
    }

    @Override
    public T set(int location, T object) {
        T t;
        synchronized (mObjects) {
            t = mObjects.set(location,object);
            notifyItemChanged(location);
        }
        return t;
    }

    @Override
    public int size() {
        return mObjects.size();
    }

    @NonNull
    @Override
    public List<T> subList(int start, int end) {
        return mObjects.subList(start, end);
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return mObjects.toArray();
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(T1[] array) {
        return mObjects.toArray(array);
    }

}
