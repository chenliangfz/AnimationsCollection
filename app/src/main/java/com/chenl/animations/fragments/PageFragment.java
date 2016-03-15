package com.chenl.animations.fragments;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.chenl.animations.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Chen,L on 2016/3/15.
 */
@EFragment(R.layout.fragment_page)
public class PageFragment extends Fragment {
    @ViewById(R.id.icon)
    ImageView mPageIcon;

    @AfterViews
    void afterViews(){

    }
}
