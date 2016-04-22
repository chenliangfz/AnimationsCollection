package com.chenl.animations.core;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.chenl.animations.R;

/**
 * Created by chenliang19 on 2016/3/14.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(Color.WHITE);
    }

    public void start(FragmentActivity fragmentActivity) {
        start(fragmentActivity.getSupportFragmentManager());
    }

    public void start(FragmentManager fragmentManager) {
        start(fragmentManager, R.id.container, getTag());
    }

    public void start(FragmentManager fragmentManager, @IdRes int containerViewId, String tag) {
        fragmentManager.beginTransaction()
                .add(containerViewId, this, tag)
                .addToBackStack(makeStackName())
                .commitAllowingStateLoss();
    }

    private final String makeStackName(){
        return getClass().getName() + ":"+hashCode();
    }
}
