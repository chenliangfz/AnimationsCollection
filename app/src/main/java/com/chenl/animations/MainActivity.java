package com.chenl.animations;

import android.widget.ListView;

import com.chenl.animations.core.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewById(R.id.list)
    ListView mListView;

    @AfterViews
    void afterViews(){
    }
}
