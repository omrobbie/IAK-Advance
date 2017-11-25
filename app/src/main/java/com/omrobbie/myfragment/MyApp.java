package com.omrobbie.myfragment;

import android.app.Application;

import com.omrobbie.myfragment.api.RestClient;

/**
 * Created by omrobbie on 25/11/2017.
 */

public class MyApp extends Application {

    private static RestClient rest;

    @Override
    public void onCreate() {
        super.onCreate();
        rest = new RestClient();
    }

    public static RestClient getRest() {
        return rest;
    }
}
