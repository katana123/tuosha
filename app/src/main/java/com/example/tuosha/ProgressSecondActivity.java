package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;


public class ProgressSecondActivity extends AppCompatActivity {
    private TextView txt_title;
    private FrameLayout fl_card;
    private Context mContext;
    private ArrayList<CardBean> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;
    private ImageButton backbtn;
    private  String bar_title;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_progress_second);
        mContext = ProgressSecondActivity.this;
        fManager = getFragmentManager();
        bindViews();


        bar_title="进度查询";
        ProgressListFragment nlFragment = new ProgressListFragment(fManager, bar_title);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_card, nlFragment);
        ft.commit();

        backbtn = findViewById(R.id.imageButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fManager.getBackStackEntryCount() == 0) {
                    finish();
                } else {
                    fManager.popBackStack();
                    txt_title.setText("进度查询");
                }
            }
        });
    }

    private void bindViews() {
        txt_title = (TextView) findViewById(R.id.card_title);
        fl_card = (FrameLayout) findViewById(R.id.fl_card);
    }

    @Override
    public void onBackPressed() {
        if (fManager.getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fManager.popBackStack();
            txt_title.setText("进度查询");
        }
    }
    public void onDestory(){
        removeActivity(this);
    }
}