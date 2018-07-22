package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.tuosha.model.ContentBean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

@SuppressLint("ValidFragment")
class ArticleContentFragment extends Fragment{
    private FragmentManager fManager;
    private String txt_title;
    private ArrayList<ContentBean> datas;

    public ArticleContentFragment() {
    }

    ArticleContentFragment(FragmentManager fManager, String txt_title) {
        this.fManager = fManager;
        this.txt_title = txt_title;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        TextView txt_title = view.findViewById(R.id.txt_title);
        //getArgument获取传递过来的Bundle对象
        Bundle a = getArguments();
        String title = a.getString("name");
        String time = a.getString("newstime");
        String apply_num = a.getString("apply_num");
        String extInfo = a.getString("extInfo");
        txt_title.setText(title);

        TextView pub_time = view.findViewById(R.id.pub_time);
        pub_time.setText(time);

        TextView read_count = view.findViewById(R.id.read_count);
        read_count.setText(apply_num);

        WebView webview = view.findViewById(R.id.txt_content);
        webview.loadData(extInfo, "text/html; charset=UTF-8", null);
        System.out.println("2222222222```````````````````````" + extInfo);
        return view;
    }

}
