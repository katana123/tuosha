package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<NewsBean> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;
    private ImageButton backbtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_second);
        mContext = SecondActivity.this;
        fManager = getFragmentManager();
        bindViews();

        datas = new ArrayList<NewsBean>();
        for (int i = 1; i <= 20; i++) {
            NewsBean data = new NewsBean("新闻标题" + i, i + "~新闻内容~~~~~~~~",getResources().getDrawable(R.drawable.contentpage),i+"",i+"",i+"");
            datas.add(data);
        }

        ArticleListFragment nlFragment = new ArticleListFragment(fManager,datas);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_content, nlFragment);
        ft.commit();

        backbtn = findViewById(R.id.imageButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fManager.getBackStackEntryCount() == 0) {
                    finish();
                } else {
                    fManager.popBackStack();
                    txt_title.setText("如何入会");
                }
            }
        });
    }

    private void bindViews() {
        txt_title = (TextView) findViewById(R.id.article_title);
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
    }

    @Override
    public void onBackPressed() {
        if (fManager.getBackStackEntryCount() == 0) {
                super.onBackPressed();
        } else {
            fManager.popBackStack();
            txt_title.setText("如何入会");
        }
    }
}
