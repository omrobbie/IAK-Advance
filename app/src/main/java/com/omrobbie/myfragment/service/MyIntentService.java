package com.omrobbie.myfragment.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by omrobbie on 12/11/2017.
 */

public class MyIntentService extends IntentService {

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
