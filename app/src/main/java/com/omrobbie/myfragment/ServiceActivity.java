package com.omrobbie.myfragment;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.omrobbie.myfragment.receiver.MyBroadcastReceiver;
import com.omrobbie.myfragment.service.MyService;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;

    private MyBroadcastReceiver receiver = new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ServiceActivity.this, MyService.class);
        startService(intent);
    }
}
