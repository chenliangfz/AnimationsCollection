package com.chenl.animations.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenl.animations.R;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterPreferences;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Chen,L on 2016/3/15.
 */
@EFragment(R.layout.fragment_page)
public class PageFragment extends Fragment {

    public static final String POSITION_BUNDLE = "POSITION_BUNDLE";

    @ViewById(R.id.title)
    TextView mPageContent;

    int mPosition;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPosition = getArguments().getInt(POSITION_BUNDLE);
    }

    @AfterViews
    void afterViews(){
        mPageContent.setText("Position:"+mPosition);
    }
}
