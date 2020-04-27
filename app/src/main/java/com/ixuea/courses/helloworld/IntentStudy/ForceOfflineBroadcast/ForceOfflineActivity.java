package com.ixuea.courses.helloworld.IntentStudy.ForceOfflineBroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ixuea.courses.helloworld.R;

public class ForceOfflineActivity extends BaseActivity {

    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_offline);
        Button button = findViewById(R.id.btn_offline);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ixuea.courses.helloworld.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
