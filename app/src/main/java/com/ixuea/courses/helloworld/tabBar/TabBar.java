package com.ixuea.courses.helloworld.tabBar;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ixuea.courses.helloworld.R;

public class TabBar extends AppCompatActivity {

//    @BindView(R.id.tabbar_rg)
    RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bar);
//        ButterKnife.bind(this);
        mRg = findViewById(R.id.tabbar_rg);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content,new TestFragment1()).commitAllowingStateLoss();
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                switch (radioButton.getId()) {
                    case R.id.rb_home:
                        Toast.makeText(TabBar.this, "主页", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new TestFragment1()).commitAllowingStateLoss();

                        break;
                    case R.id.rb_mine:
                        Toast.makeText(TabBar.this, "我的", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new TestFragment2()).commitAllowingStateLoss();
                        break;
                }
            }
        });
    }



}
