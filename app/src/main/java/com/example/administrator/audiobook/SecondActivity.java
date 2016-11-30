package com.example.administrator.audiobook;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class SecondActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager viewPager;
    String[] mTitleList = new String[]{"四大组件","线程","框架","网络加载","性能优化","自定义","Java"};
    List<Fragment> fragments = new ArrayList<Fragment>();
    ZhihuMainAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(R.mipmap.ic_brightness_medium_white_36dp);
        ab.setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) this.findViewById(R.id.viewpager);
        mTabLayout= (TabLayout) findViewById(R.id.tabs);
        //1.MODE_SCROLLABLE模式
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        fragments.add(new MyFragmrnt());
        fragments.add(new MyFragmrnt());
        fragments.add(new MyFragmrnt());
        fragments.add(new MyFragmrnt());
        fragments.add(new MyFragmrnt());
        fragments.add(new MyFragmrnt());
        fragments.add(new JavaFragmrnt());
        mAdapter = new ZhihuMainAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mAdapter);

        //此处遇过一个坑，就是用你AS版本对应的 compile 'com.android.support:design:25.0.1'依赖，我用的AS版本为2.2.2，否则报错
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[0]));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[1]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[2]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[3]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[4]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[5]));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList[6]));
        mTabLayout.setupWithViewPager(viewPager);
        mTabLayout.getTabAt(0).setText(mTitleList[0]);
        mTabLayout.getTabAt(1).setText(mTitleList[1]);
        mTabLayout.getTabAt(2).setText(mTitleList[2]);
        mTabLayout.getTabAt(3).setText(mTitleList[3]);
        mTabLayout.getTabAt(4).setText(mTitleList[4]);
        mTabLayout.getTabAt(5).setText(mTitleList[5]);
        mTabLayout.getTabAt(6).setText(mTitleList[6]);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab_layout, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_settings:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
