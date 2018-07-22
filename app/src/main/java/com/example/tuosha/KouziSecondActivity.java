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

import static com.example.tuosha.Utils.ActivityCollector.addActivity;


public class KouziSecondActivity extends AppCompatActivity {
    private TextView txt_title;
    private FrameLayout fl_kouzi;
    private Context mContext;
    private ArrayList<KouziBean> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;
    private ImageButton backbtn;
    private  String bar_title;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_kouzi_second);
        mContext = KouziSecondActivity.this;
        fManager = getFragmentManager();
        bindViews();


        bar_title="大额贷款";
        KouziListFragment nlFragment = new KouziListFragment(fManager, bar_title);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_kouzi, nlFragment);
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
        txt_title = (TextView) findViewById(R.id.kouzi_title);
        fl_kouzi = (FrameLayout) findViewById(R.id.fl_kouzi);
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