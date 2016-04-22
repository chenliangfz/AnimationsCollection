package com.chenl.animations;

import com.chenl.animations.modles.HomeModel;

import java.util.ArrayList;

/**
 * Created by Chen,L on 2016/3/14.
 */
public class Mocks {
    public static ArrayList<HomeModel> homeModels;
    static {
        homeModels = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            HomeModel homeModel = new HomeModel();
            homeModel.title = "Title:"+i;
            homeModels.add(homeModel);
        }
    }
}
