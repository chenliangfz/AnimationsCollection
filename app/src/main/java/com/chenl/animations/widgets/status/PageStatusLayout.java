package com.chenl.animations.widgets.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.chenl.animations.R;

/**
 * Created by chenliang19 on 2016/3/14.
 */
public class PageStatusLayout extends FrameLayout implements OnPageStatusListener {

    private PageStatus mCurrentStatus = PageStatus.EMPTY;

    private int mLoadingLayoutResId = View.NO_ID;

    private View mLayoutLoading;

    private int mErrorLayoutResId = View.NO_ID;

    private View mLayoutError;

    private int mEmptyLayoutResId = View.NO_ID;

    private View mLayoutEmpty;

    private OnPageStatusListener mPagerStatusListener;

    public PageStatusLayout(Context context) {
        super(context);
        show(mCurrentStatus);
    }

    public PageStatusLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        obtainAttrs(context, attrs);
        show(mCurrentStatus);
    }

    public PageStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        obtainAttrs(context, attrs);
        show(mCurrentStatus);
    }

    private void obtainAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PageStatusLayout);
        mCurrentStatus = PageStatus.getPaggStatus(typedArray.getInt(R.styleable.PageStatusLayout_show_status, PageStatus.EMPTY.value));
        mEmptyLayoutResId = typedArray.getResourceId(R.styleable.PageStatusLayout_layout_empty, View.NO_ID);
        mLoadingLayoutResId = typedArray.getResourceId(R.styleable.PageStatusLayout_layout_loading, View.NO_ID);
        mErrorLayoutResId = typedArray.getResourceId(R.styleable.PageStatusLayout_layout_error, View.NO_ID);
        typedArray.recycle();
    }

    @Override
    public void onLoading() {
        show(PageStatus.LOADING);
    }

    @Override
    public void onError() {
        show(PageStatus.ERROR);
    }

    @Override
    public void onEmpty() {
        show(PageStatus.EMPTY);
    }

    @Override
    public void onSucceed() {
        show(PageStatus.SUCCESS);
    }

    private void show(PageStatus status) {
        if (status == PageStatus.EMPTY && null == mLayoutEmpty && mEmptyLayoutResId != View.NO_ID) {
            mLayoutEmpty = createLayout(getContext(), mEmptyLayoutResId);
            if (mLayoutEmpty != null) {
                mLayoutEmpty.setOnClickListener(
                        new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mPagerStatusListener != null) {
                                    mPagerStatusListener.onLoading();
                                }
                            }
                        }
                );
                addView(mLayoutEmpty);
            }
        }
        if (mLayoutEmpty != null) {
            mLayoutEmpty.setVisibility((status == PageStatus.EMPTY) ? View.VISIBLE : View.GONE);
        }

        if (status == PageStatus.ERROR && null == mLayoutError && mErrorLayoutResId != View.NO_ID) {
            mLayoutError = createLayout(getContext(), mErrorLayoutResId);
            if (mLayoutError != null) {
                mLayoutError.setOnClickListener(
                        new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mPagerStatusListener != null) {
                                    mPagerStatusListener.onLoading();
                                }
                            }
                        }
                );
                addView(mLayoutError);
            }
        }
        if (mLayoutError != null) {
            mLayoutError.setVisibility((status == PageStatus.ERROR) ? View.VISIBLE : View.GONE);
        }

        if (status == PageStatus.LOADING && null == mLayoutLoading && mLoadingLayoutResId != View.NO_ID) {
            mLayoutLoading = createLayout(getContext(), mLoadingLayoutResId);
            if (mLayoutLoading!=null) {
                addView(mLayoutLoading);
            }
        }
        if (mLayoutLoading != null) {
            mLayoutLoading.setVisibility((status == PageStatus.LOADING) ? View.VISIBLE : View.GONE);
        }
    }

    private View createLayout(Context context, int layoutResId) {
        View view;
        try {
            view = LayoutInflater.from(context).inflate(layoutResId, this, false);
        } catch (Exception e) {
            view = null;
        }
        return view;
    }

    public void setPagerStatusListener(OnPageStatusListener statusListener) {
        mPagerStatusListener = statusListener;
    }
}
