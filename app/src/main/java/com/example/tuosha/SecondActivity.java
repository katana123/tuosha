package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuosha.model.ContentBean;

import java.util.ArrayList;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView txt_title;
    private FrameLayout fl_content;
    private Context mContext;
    private ArrayList<ContentBean> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;
    private ImageButton backbtn;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.acticity_second);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        final int jisuId = bd.getInt("jisuId");
        final String erTitle = bd.getString("erTitle");
        mContext = SecondActivity.this;
        fManager = getFragmentManager();
        bindViews();

        ArticleListFragment nlFragment = new ArticleListFragment(fManager, erTitle, jisuId);
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

    @SuppressLint("ResourceType")
    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        int type = bd.getInt("type");
        if (type == 3) {

            fManager = getFragmentManager();
            FragmentTransaction fTransaction = fManager.beginTransaction();
            ArticleContentFragment ncFragment = new ArticleContentFragment(fManager, "技术专区");
            ncFragment.setArguments(bd);
            //获取Activity的控件
            //bar_title
            TextView txt_title = (TextView) findViewById(R.id.article_title);
            txt_title.setText("技术专区");

            //加上FragmentgetDes替换动画
            fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
            fTransaction.replace(R.id.fl_content, ncFragment);
            //调用addToBackStack将Fragment添加到栈中
            fTransaction.addToBackStack(null);
            fTransaction.commit();

        }
    }

    @Override
    public void onBackPressed() {
        System.out.println(fManager.getBackStackEntryCount());
        if (fManager.getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fManager.popBackStack();
            txt_title.setText("如何入会");
        }
    }
} 