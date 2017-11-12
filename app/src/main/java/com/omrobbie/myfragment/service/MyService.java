package com.omrobbie.myfragment.service;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by omrobbie on 12/11/2017.
 */

public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: Service Started!");
        new doSomething().execute();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static class doSomething extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=0; i<=10; i++) {
                try {
                    Thread.sleep(1000);
                    Log.i(TAG, "doInBackground: sync data " + i );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TAG, "doInBackground: finish!");
            super.onPostExecute(aVoid);
        }
    }
}
