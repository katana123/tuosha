package com.example.tuosha;

import android.annotation.SuppressLint;
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
public class ArticleListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FragmentManager fManager;
    private ArrayList<NewsBean> datas;
    private ListView list_news;

    @SuppressLint("ValidFragment")
    public ArticleListFragment(FragmentManager fManager, ArrayList<NewsBean> datas) {
        this.fManager = fManager;
        this.datas = datas;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_articlelist, container, false);
        list_news = (ListView) view.findViewById(R.id.list_article);
        NewsAdapter myAdapter = new NewsAdapter(getActivity(), datas);
        list_news.setAdapter(myAdapter);
        list_news.setOnItemClickListener(this);
        return view;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        FragmentTransaction fTransaction = fManager.beginTransaction();
        ArticleContentFragment ncFragment = new ArticleContentFragment();
        Bundle bd = new Bundle();
        bd.putString("content", datas.get(position).getDes());
        ncFragment.setArguments(bd);
        //获取Activity的控件
        TextView txt_title = (TextView) getActivity().findViewById(R.id.article_title);
        txt_title.setText(datas.get(position).getDes());
        //加上FragmentgetDes替换动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_content, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }
}
