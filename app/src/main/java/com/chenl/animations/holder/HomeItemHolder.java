package com.chenl.animations.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.chenl.animations.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Chen,L on 2016/3/14.
 */
@EViewGroup(R.layout.item_home)
public class HomeItemHolder extends FrameLayout {

    @ViewById(R.id.title)
    TextView mTxtTitle;

    public HomeItemHolder(Context context) {
        super(context);
    }

    public void bindView(String value){
        mTxtTitle.setText(value);
    }

}
