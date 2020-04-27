package com.ixuea.courses.helloworld.IntentStudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ixuea.courses.helloworld.IntentStudy.BroadcastStudy.LocalBroadcastActivity;
import com.ixuea.courses.helloworld.IntentStudy.BroadcastStudy.NetworkBorderCastActivity;
import com.ixuea.courses.helloworld.IntentStudy.ForceOfflineBroadcast.ForceOfflineActivity;
import com.ixuea.courses.helloworld.R;

public class IntentIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_index);
        Button mBtn1 = findViewById(R.id.intent1);
        Button mBtn2 = findViewById(R.id.intent2);
        Button mBtn3 = findViewById(R.id.intent3);
        Button mBtn4 = findViewById(R.id.intent4);
        Button mBtn5 = findViewById(R.id.intent5);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentIndex.this,FirstIntent.class);
                startActivity(intent);
            }
        });
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentIndex.this, NetworkBorderCastActivity.class);
                startActivity(intent);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ixuea.courses.helloworld.MY_BROADCAST");
                sendOrderedBroadcast(intent,null);
            }
        });
        mBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentIndex.this, LocalBroadcastActivity.class);
                startActivity(intent);
            }
        });
        mBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentIndex.this, ForceOfflineActivity.class);
                startActivity(intent);
            }
        });
    }
}
