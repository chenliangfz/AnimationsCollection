package com.chenl.animations.widgets.status;

/**
 * Created by chenliang19 on 2016/2/29.
 */
public interface OnPageStatusListener {
    void onLoading();

    void onError();

    void onEmpty();

    void onSucceed();
}
