package com.ixuea.courses.helloworld.IntentStudy.BroadcastStudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ixuea.courses.helloworld.R;

public class LocalBroadcastActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private LocalBroadcastReceiver localBroadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_broadcast);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
                Intent intent = new Intent("com.ixuea.courses.helloworld.LOCAL_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.ixuea.courses.helloworld.LOCAL_BROADCAST");
        localBroadcastReceiver = new LocalBroadcastReceiver();
        localBroadcastManager.registerReceiver(localBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localBroadcastReceiver);
    }
}
