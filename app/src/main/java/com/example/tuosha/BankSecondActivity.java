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

import com.example.tuosha.client.CustomApplication;

import java.util.ArrayList;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;


public class BankSecondActivity extends AppCompatActivity {
    private TextView txt_title;
    private FrameLayout fl_bank;
    private Context mContext;
    private ArrayList<BankBean> datas = null;
    private FragmentManager fManager = null;
    private long exitTime = 0;
    private ImageButton backbtn;
    private  String bar_title;
    private CustomApplication customApplication;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_bank_second);
        customApplication = (CustomApplication) getApplication();
        customApplication.setBankSecondActivity(this);

        mContext = BankSecondActivity.this;
        fManager = getFragmentManager();
        bindViews();


        bar_title="大额通道";
        BankListFragment nlFragment = new BankListFragment(fManager, bar_title);
        FragmentTransaction ft = fManager.beginTransaction();
        ft.replace(R.id.fl_bank, nlFragment);
        ft.commit();

        backbtn = findViewById(R.id.imageButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fManager.getBackStackEntryCount() == 0) {
                    finish();
                } else {
                    fManager.popBackStack();
                    txt_title.setText("提额通道");
                }
            }
        });
    }

    private void bindViews() {
        txt_title = findViewById(R.id.bank_title);
        fl_bank = findViewById(R.id.fl_bank);
    }

    @Override
    public void onBackPressed() {
        if (fManager.getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fManager.popBackStack();
            txt_title.setText("提额通道");
        }
    }
}