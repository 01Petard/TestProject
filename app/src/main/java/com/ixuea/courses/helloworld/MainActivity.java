package com.ixuea.courses.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ixuea.courses.helloworld.BascialView.ButtonActivity;
import com.ixuea.courses.helloworld.BascialView.CheckBoxActivity;
import com.ixuea.courses.helloworld.BascialView.EditTextActivity;
import com.ixuea.courses.helloworld.BascialView.ImageViewActivity;
import com.ixuea.courses.helloworld.BascialView.RadioButtonActivity;
import com.ixuea.courses.helloworld.BascialView.TextViewActivity;
import com.ixuea.courses.helloworld.Chat.ChatActivity;
import com.ixuea.courses.helloworld.IntentStudy.FirstIntent;
import com.ixuea.courses.helloworld.IntentStudy.IntentIndex;
import com.ixuea.courses.helloworld.Menu.ContextMenuActivity;
import com.ixuea.courses.helloworld.Menu.OptionMenuActivity;
import com.ixuea.courses.helloworld.gridview.GridViewActivity;
import com.ixuea.courses.helloworld.listview.ListViewActivity;
import com.ixuea.courses.helloworld.recycleview.RecycleViewActivity;
import com.ixuea.courses.helloworld.FilterBar.FilterBar;
import com.ixuea.courses.helloworld.tabBar.TabBar;
import com.ixuea.courses.helloworld.tabPage.TabPage;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRv;
    private Button mBtnTabPage;
    private Button mBtnTabBar;
    private Button mBtnFilterBar;
    private Button mBtnWebView;
    private Button mBtnOptionMenu;
    private Button mBtnContextMenu;
    private Button mBtnChat;
    private Button mBtnIntent;
    private Button mBtnqizhongkaoshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnRv = findViewById(R.id.btn_recycleview);
        mBtnTabPage = findViewById(R.id.btn_tabPage);
        mBtnTabBar = findViewById(R.id.btn_tabBar);
        mBtnFilterBar = findViewById(R.id.btn_filterBar);
        mBtnWebView = findViewById(R.id.btn_webView);
        mBtnOptionMenu = findViewById(R.id.btn_optionMenu);
        mBtnContextMenu = findViewById(R.id.btn_contextMenu);
        mBtnChat = findViewById(R.id.btn_chat);
        mBtnIntent = findViewById(R.id.btn_intent);
        mBtnqizhongkaoshi = findViewById(R.id.btn_qizhongkaoshi);
        setListers();

    }

    public void showToast(View view) {
        Toast.makeText(this, "我被点击了", Toast.LENGTH_SHORT).show();
    }

    private void setListers() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRv.setOnClickListener(onClick);
        mBtnTabPage.setOnClickListener(onClick);
        mBtnTabBar.setOnClickListener(onClick);
        mBtnFilterBar.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnOptionMenu.setOnClickListener(onClick);
        mBtnContextMenu.setOnClickListener(onClick);
        mBtnChat.setOnClickListener(onClick);
        mBtnIntent.setOnClickListener(onClick);
        mBtnqizhongkaoshi.setOnClickListener(onClick);
    }

    public class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recycleview:
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_tabPage:
                    intent = new Intent(MainActivity.this, TabPage.class);
                    break;
                case R.id.btn_tabBar:
                    intent = new Intent(MainActivity.this, TabBar.class);
                    break;
                case R.id.btn_filterBar:
                    intent = new Intent(MainActivity.this, FilterBar.class);
                    break;
                case R.id.btn_webView:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_optionMenu:
                    intent = new Intent(MainActivity.this, OptionMenuActivity.class);
                    break;
                case R.id.btn_contextMenu:
                    intent = new Intent(MainActivity.this, ContextMenuActivity.class);
                    break;
                case R.id.btn_chat:
                    intent = new Intent(MainActivity.this, ChatActivity.class);
                    break;
                case R.id.btn_intent:
                    intent = new Intent(MainActivity.this, IntentIndex.class);
                    break;
                case R.id.btn_qizhongkaoshi:
                    intent = new Intent(MainActivity.this, qizhongkaoshi1Activity.class);
                    break;
            }
            startActivity(intent);
        }
    }


}
