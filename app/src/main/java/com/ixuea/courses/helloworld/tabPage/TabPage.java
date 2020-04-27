package com.ixuea.courses.helloworld.tabPage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ixuea.courses.helloworld.R;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;


public class TabPage extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<MyFragment> fragments;
    ViewPageAdapter viewPageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_page);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        init();
        //设置适配器
        viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(),BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,fragments);
        viewPager.setAdapter(viewPageAdapter);

        //关联ViewPager
        tabLayout.setupWithViewPager(viewPager);

        //改变tabLayout的滑动方式
        //推荐item较多时使用，宽度固定，自动水平排列
//        tabLayout.setTabMode(TabLayout.MODE_AUTO);
        //推荐item较少时使用，平分宽度，所有item都在屏幕上
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
    public void init(){
        //初始化数据
        fragments = new ArrayList<>();
        fragments.add(new MyFragment("体育",R.layout.viewpage_item1));
        fragments.add(new MyFragment("政治",R.layout.viewpage_item2));
        fragments.add(new MyFragment("金融",R.layout.viewpage_item3));
    }
}