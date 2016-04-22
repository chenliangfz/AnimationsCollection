package com.chenl.animations;

import android.support.v7.widget.Toolbar;

import com.chenl.animations.core.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewById(R.id.tool_bar)
    Toolbar mToolbar;

    @AfterViews
    void afterViews(){
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
    }
}
