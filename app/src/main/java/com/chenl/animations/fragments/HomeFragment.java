package com.chenl.animations.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chenl.animations.R;
import com.chenl.animations.core.BaseFragment;
import com.chenl.animations.core.adapter.list.ViewArrayAdapter;
import com.chenl.animations.holder.HomeItemHolder;
import com.chenl.animations.holder.HomeItemHolder_;
import com.chenl.animations.modles.HomeModel;
import com.chenl.animations.utils.L;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chen,L on 2016/4/21.
 */
@EFragment(R.layout.fragment_list)
public class HomeFragment extends BaseFragment {
    @ViewById(R.id.list)
    ListView mListView;

    HomeAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @AfterViews
    void afterViews(){
        mAdapter = new HomeAdapter();
        mAdapter.addAll(createHomeModles());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HorizontalPagerFragment_.builder().build().start(getActivity());
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        L.e("onCreateContextMenu");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        L.e("onCreateOptionsMenu");
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        L.e("onOptionsMenuClosed");
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        L.e("onPrepareOptionsMenu");
        super.onPrepareOptionsMenu(menu);
    }

    private final List<HomeModel> createHomeModles() {
        final List<HomeModel> homeModels = new ArrayList<>();
        HomeModel homeModel = new HomeModel();
        homeModel.title = "ViewPager";
        homeModels.add(homeModel);
        for (int i = 0; i < 20; i++) {
            HomeModel model = new HomeModel();
            model.title = "Title:"+i;
            homeModels.add(model);
        }
        return homeModels;
    }

    private class HomeAdapter extends ViewArrayAdapter<HomeModel,HomeItemHolder> {

        @Override
        protected HomeItemHolder createView(Context context) {
            return HomeItemHolder_.build(context);
        }

        @Override
        protected void bindView(int position, HomeItemHolder view, HomeModel item) {
            view.bindView(item.title);
        }
    }
}
