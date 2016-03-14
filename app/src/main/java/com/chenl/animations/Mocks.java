package com.chenl.animations;

import com.chenl.animations.modles.HomeModle;

import java.util.ArrayList;

/**
 * Created by Chen,L on 2016/3/14.
 */
public class Mocks {
    public static ArrayList<HomeModle> homeModles;
    static {
        homeModles = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            HomeModle homeModle = new HomeModle();
            homeModle.title = "Title:"+i;
            homeModles.add(homeModle);
        }
    }
}
