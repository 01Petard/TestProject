package com.ixuea.courses.helloworld.IntentStudy.BroadcastStudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isConnected(context)){
            if(isWifi(context)){
                Toast.makeText(context, "无线网络已连接！", Toast.LENGTH_SHORT).show();
            }else if(isMobile(context)){
                Toast.makeText(context, "移动数据已连接！", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "未知网络连接方式！", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(context, "网络断开！", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * android10版本
     * 判断网络类型：移动网络
     */
    public static boolean isMobile(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = cm.getActiveNetwork();
        if (null == network) {
            return false;
        }
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
        if (null == capabilities) {
            return false;
        }
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR);
    }


    /**
     * android10版本
     * 判断网络类型：Wi-Fi类型
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = cm.getActiveNetwork();
        if (null == network) {
            return false;
        }
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
        if (null == capabilities) {
            return false;
        }
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
    }

    /**
     * android10版本
     * 判断网络是否连接
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = cm.getActiveNetwork();
        if (null == network) {
            return false;
        }
        NetworkCapabilities capabilities = cm.getNetworkCapabilities(network);
        if (null == capabilities) {
            return false;
        }
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
    }
}

