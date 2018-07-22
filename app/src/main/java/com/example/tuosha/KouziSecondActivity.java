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
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tuosha.model.KouziBean;

import java.util.ArrayList;


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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_kouzi_second);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        final int kouziId = bd.getInt("kouziId");
        final String erTitle = bd.getString("erTitle");
        mContext = KouziSecondActivity.this;
        fManager = getFragmentManager();
        bindViews(erTitle);


        bar_title = erTitle;
        KouziListFragment nlFragment = new KouziListFragment(fManager, bar_title, kouziId);
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
                    txt_title.setText(erTitle);
                }
            }
        });
    }

    private void bindViews(String kouzi_title) {
        txt_title = findViewById(R.id.kouzi_title);
        fl_kouzi = findViewById(R.id.fl_kouzi);
        txt_title.setText(kouzi_title);
    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        final String erTitle = bd.getString("erTitle");
        if (fManager.getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fManager.popBackStack();
            txt_title.setText(erTitle);
        }
    }
}