package com.ixuea.courses.helloworld.IntentStudy.BroadcastStudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "我是自定义的广播", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
