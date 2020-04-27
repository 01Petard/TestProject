package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWvMain = findViewById(R.id.wv);
        /*加载本地Html*/
//        mWvMain.loadUrl("file:///android_asset/test.html");
//        mWvMain.loadUrl("file:///android_asset/html/Homepage.html");
        /*加载网络Html*/
        mWvMain.getSettings().setJavaScriptEnabled(true);//对webview进行js的支持
        mWvMain.getSettings().setDomStorageEnabled(true);
//        mWvMain.setWebViewClient(new WebViewClient());//防止转跳到浏览器，比较简单的一种操作
        mWvMain.setWebViewClient(new MyWebViewCilent());
        mWvMain.setWebChromeClient(new MyWebChromeClient());
//        mWvMain.addJavascriptInterface();//这个方法可以在本地写一些java方法
        mWvMain.loadUrl("https://m.baidu.com");

    }
    class MyWebViewCilent extends WebViewClient{
        //在App内页面转跳，不通过浏览器
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebViewActivity","onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebViewActivity","onPageFinished...");
//            mWvMain.loadUrl("javascript:alert('hello')");//当页面加载完毕后，会弹出一个对话框
//            mWvMain.evaluateJavascript("javascript:alert('hello')",null);//当页面加载完毕后，会弹出一个对话框
        }
    }
    class MyWebChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }
    //在WebView内返回的时候返回上一个页面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && mWvMain.canGoBack()){
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
