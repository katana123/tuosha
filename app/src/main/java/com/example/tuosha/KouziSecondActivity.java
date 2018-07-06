package com.example.tuosha;

import android.app.Fragment;
import android.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;


public class KouziSecondActivity extends AppCompatActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kouzi_second);



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
            if (tag.equals(KouziListFragment.class.getName())) {
                fragment = KouziListFragment.newInstance();
            } else if (tag.equals(KouziContentFragment.class.getName())) {
                fragment = KouziContentFragment.newInstance();
            }
            mFragmentList.add(fragment);
            transaction.add(R.id.fl_kouzi, fragment, fragment.getClass().getName());
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

}
