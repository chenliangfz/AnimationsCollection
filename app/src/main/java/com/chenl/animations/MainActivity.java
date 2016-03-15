package com.chenl.animations;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.chenl.animations.core.BaseActivity;
import com.chenl.animations.core.adapter.list.ViewArrayAdapter;
import com.chenl.animations.holder.HomeItemHolder;
import com.chenl.animations.holder.HomeItemHolder_;
import com.chenl.animations.modles.HomeModle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewById(R.id.list)
    ListView mListView;

    HomeAdapter mAdapter;

    @ViewById(R.id.tool_bar)
    Toolbar mToolbar;

    @AfterViews
    void afterViews(){
        setSupportActionBar(mToolbar);
        mAdapter = new HomeAdapter();
        mListView.setAdapter(mAdapter);
        mAdapter.addAll(createHomeModles());
    }

    private final List<HomeModle> createHomeModles() {
        final List<HomeModle> homeModles = new ArrayList<>();
        HomeModle homeModle = new HomeModle();
        homeModle.title = "ViewPager";
        homeModles.add(homeModle);
        for (int i = 0; i < 20; i++) {
            HomeModle modle = new HomeModle();
            modle.title = "Title:"+i;
            homeModles.add(modle);
        }
        return homeModles;
    }

    private class HomeAdapter extends ViewArrayAdapter<HomeModle,HomeItemHolder>{

        @Override
        protected HomeItemHolder createView(Context context) {
            return HomeItemHolder_.build(context);
        }

        @Override
        protected void bindView(int position, HomeItemHolder view, HomeModle item) {
            view.bindView(item.title);
        }
    }
}
