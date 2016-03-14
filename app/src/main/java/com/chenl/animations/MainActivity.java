package com.chenl.animations;

import android.content.Context;
import android.widget.ListView;

import com.chenl.animations.core.BaseActivity;
import com.chenl.animations.core.adapter.list.ViewArrayAdapter;
import com.chenl.animations.holder.HomeItemHolder;
import com.chenl.animations.holder.HomeItemHolder_;
import com.chenl.animations.modles.HomeModle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewById(R.id.list)
    ListView mListView;

    HomeAdapter mAdapter;

    @AfterViews
    void afterViews(){
        mAdapter = new HomeAdapter();
        mListView.setAdapter(mAdapter);
        mAdapter.addAll(Mocks.homeModles);
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
