package com.example.administrator.audiobook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/29.
 */

public class TextViewActivity extends AppCompatActivity{
    private TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
//        ab.setHomeAsUpIndicator(R.mipmap.ic_brightness_medium_white_36dp);
        ab.setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        Intent intent=getIntent();
        textView1= (TextView) findViewById(R.id.tv_content);
        textView2= (TextView) findViewById(R.id.tv_content1);
        textView1.setText(intent.getStringExtra("question").toString());
        textView2.setText(intent.getStringExtra("answer").toString());
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
