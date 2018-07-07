package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class CardListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FragmentManager fManager;
    private ArrayList<CardBean> datas;
    private ListView list_news;
    private String txt_title;
    private Context mContext;

    @SuppressLint("ValidFragment")
    public CardListFragment(FragmentManager fManager, ArrayList<CardBean> datas) {
        this.fManager = fManager;
        this.datas = datas;
    }
    @SuppressLint("ValidFragment")
    public CardListFragment(FragmentManager fManager, String txt_title) {
        this.fManager = fManager;
        this.txt_title = txt_title;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_list, container, false);

        //1.获取新闻数据用list封装
        mContext = getActivity();
        datas = CardUtils.getAllNews(mContext);
        //2.找到控件
        ListView lv_card = (ListView) view.findViewById(R.id.list_card);
        //3.创建一个adapter设置给listview
        CardAdapter cardAdapter = new CardAdapter(mContext, datas);
        lv_card.setAdapter(cardAdapter);
        //4.设置listview条目的点击事件
        lv_card.setOnItemClickListener(this);
        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        CardContentFragment ncFragment = new CardContentFragment();
        Bundle bd = new Bundle();
        bd.putString("content", datas.get(position).getDes());
        ncFragment.setArguments(bd);
        //获取Activity的控件
        //bar_title
        TextView txt_title = (TextView) getActivity().findViewById(R.id.card_title);
        txt_title.setText("提额通道");
        // 标题
        TextView s_title = (TextView) getActivity().findViewById(R.id.s_title);
       // s_title.setText(datas.get(position).getDes());
        //s_title.setText("sdgdafghdafhdah");
        //加上FragmentgetDes替换动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_card, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }

}
