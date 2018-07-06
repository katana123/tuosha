package com.example.tuosha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class KouziListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FragmentManager fManager;
    private ArrayList<KouziBean> datas;
    private ListView list_news;
    private String txt_title;
    private Context mContext;

    @SuppressLint("ValidFragment")
    public KouziListFragment(FragmentManager fManager, ArrayList<KouziBean> datas) {
        this.fManager = fManager;
        this.datas = datas;
    }
    @SuppressLint("ValidFragment")
    public KouziListFragment(FragmentManager fManager,String txt_title) {
        this.fManager = fManager;
        this.txt_title = txt_title;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kouzi_list, container, false);
       // list_news = (ListView) view.findViewById(R.id.list_kouzi);
       // KouziAdapter myAdapter = new KouziAdapter(getActivity(),datas);
       // list_news.setAdapter(myAdapter);
       // list_news.setOnItemClickListener(this);

        //1.获取新闻数据用list封装
        mContext = getActivity();
        ArrayList<KouziBean> allNews = KouziUtils.getAllNews(mContext);
        //2.找到控件
        ListView lv_kouzi = (ListView) view.findViewById(R.id.list_kouzi);
        //3.创建一个adapter设置给listview
        KouziAdapter kouziAdapter = new KouziAdapter(mContext, allNews);
        lv_kouzi.setAdapter(kouziAdapter);
        //4.设置listview条目的点击事件
        lv_kouzi.setOnItemClickListener(this);
        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        KouziContentFragment ncFragment = new KouziContentFragment();
        Bundle bd = new Bundle();
        bd.putString("content", datas.get(position).getDes());
        ncFragment.setArguments(bd);
        //获取Activity的控件
        TextView txt_title = (TextView) getActivity().findViewById(R.id.kouzi_title);
        txt_title.setText(datas.get(position).getDes());
        //加上FragmentgetDes替换动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_kouzi, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

}
