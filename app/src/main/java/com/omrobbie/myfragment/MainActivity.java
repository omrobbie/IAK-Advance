package com.omrobbie.myfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new OneFragment(), null)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new TwoFragment(), null)
                .commit();
    }
}
