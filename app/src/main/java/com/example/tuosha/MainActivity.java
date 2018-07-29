package com.example.tuosha;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tuosha.client.CustomApplication;

import java.util.ArrayList;
import java.util.List;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRgTab;
    //private View mview;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private CustomApplication customApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);

       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // 设置为全屏幕显示

        setContentView(R.layout.activity_main);


        customApplication = (CustomApplication) getApplication();
        customApplication.setMainActivity(this);

        initbtn();
        mRgTab = (RadioGroup) findViewById(R.id.rg_main);
        mRgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.contentpage:
                        changeFragment(ContentActivity.class.getName());
                        break;
                    case R.id.kouzipage:
                        changeFragment(KouziActivity.class.getName());
                        break;
                    case R.id.cardpage:
                        changeFragment(CardActivity.class.getName());
                        break;
                    case R.id.centerpage:
                        changeFragment(CenterActivity.class.getName());
                        break;
                }
            }
        });
        if(savedInstanceState == null){
            changeFragment(ContentActivity.class.getName());
        }
    }
    public void changeFragment(String tag) {
        hideFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);
        if (fragment != null) {
            transaction.show(fragment);
        } else {
            if (tag.equals(ContentActivity.class.getName())) {
                fragment = ContentActivity.newInstance();
            } else if (tag.equals(KouziActivity.class.getName())) {
                fragment = KouziActivity.newInstance();
            } else if (tag.equals(CardActivity.class.getName())) {
                fragment = CardActivity.newInstance();
            } else if (tag.equals(CenterActivity.class.getName())) {
                fragment = CenterActivity.newInstance();
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.mainpage, fragment, fragment.getClass().getName());
        }
        transaction.commitAllowingStateLoss();

    }

    /**
     * hide all fragment
     */
    private void hideFragment() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        for (Fragment f : mFragmentList) {
            ft.hide(f);
        }
        ft.commit();
    }

    private void initbtn(){
        //控制登录用户名图标大小
        RadioButton hpRB = (RadioButton) findViewById(R.id.contentpage);
        Drawable hpDrawable = getResources().getDrawable(R.drawable.contentpage);
        hpDrawable.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        hpRB.setCompoundDrawables(null,hpDrawable,null,null);//
        //控制登录用户名图标大小
        RadioButton hpRB2 = (RadioButton) findViewById(R.id.kouzipage);
        Drawable hpDrawable2 = getResources().getDrawable(R.drawable.kouzipage);
        hpDrawable2.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        hpRB2.setCompoundDrawables(null,hpDrawable2,null,null);//
        //控制登录用户名图标大小
        RadioButton hpRB3 = (RadioButton) findViewById(R.id.cardpage);
        Drawable hpDrawable3 = getResources().getDrawable(R.drawable.cardpage);
        hpDrawable3.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        hpRB3.setCompoundDrawables(null,hpDrawable3,null,null);//
        //控制登录用户名图标大小
        RadioButton hpRB4 = (RadioButton) findViewById(R.id.centerpage);
        Drawable hpDrawable4 = getResources().getDrawable(R.drawable.centerpage);
        hpDrawable4.setBounds(0, 0, 70, 70);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        hpRB4.setCompoundDrawables(null,hpDrawable4,null,null);//
    }
    @Override
    protected void onResume() {
        String tag = getIntent().getStringExtra("tag");
        if (tag!=null) {
            hideFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            Fragment fragment = getFragmentManager().findFragmentByTag(tag);
            if (fragment != null) {
                transaction.show(fragment);
            } else {
                if (tag.equals(("ContentActivity").toString())) {
                    fragment = ContentActivity.newInstance();
                    mRgTab.check(R.id.contentpage);
                } else if (tag.equals(("KouziActivity").toString())) {
                    fragment = KouziActivity.newInstance();
                    mRgTab.check(R.id.kouzipage);
                } else if (tag.equals(("CardActivity").toString())) {
                    fragment = CardActivity.newInstance();
                    mRgTab.check(R.id.cardpage);
                } else if (tag.equals(("CenterActivity").toString())) {
                    fragment = CenterActivity.newInstance();
                    mRgTab.check(R.id.contentpage);
                }
                mFragmentList.add(fragment);
                transaction.add(R.id.mainpage, fragment, fragment.getClass().getName());



            }
            transaction.commitAllowingStateLoss();
        }


        super.onResume();
    }

    public void onDestory(){
        removeActivity(this);
    }


}

