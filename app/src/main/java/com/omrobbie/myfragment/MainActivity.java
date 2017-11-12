package com.omrobbie.myfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.omrobbie.myfragment.listener.HostToFragmentListener;

public class MainActivity extends AppCompatActivity {

    private HostToFragmentListener hostToFragmentListener;

    public HostToFragmentListener getHostToFragmentListener() {
        return hostToFragmentListener;
    }

    public void setHostToFragmentListener(HostToFragmentListener hostToFragmentListener) {
        this.hostToFragmentListener = hostToFragmentListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int data = 3;
        OneFragment oneFragment = OneFragment.newInstance("Start fragment one with data " + data, data);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, oneFragment, null)
                .commit();

        getSupportFragmentManager().beginTransaction()
                .addToBackStack("fragment_two")
                .replace(R.id.container, new TwoFragment(), null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count > 0) getSupportFragmentManager().popBackStack();
        else super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send_to_fragment:
                hostToFragmentListener.onDataReceiveInFragment("Data dari option menu");
                break;
        }

        return true;
    }
}
