package com.example.tuosha;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;


public class KouziListFragment extends Fragment  implements AdapterView.OnItemClickListener {

    private OnFragmentInteractionListener mListener;
    private View mView;
    private TextView title;
    private KouziActivity.ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private Context mContext;

    public KouziListFragment() {
        // Required empty public constructor
    }

    public static KouziListFragment newInstance() {
        KouziListFragment fragment = new KouziListFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.activity_kouzi, null);

        //1.获取新闻数据用list封装
        mContext = getActivity();
        ArrayList<KouziBean> allNews = KouziUtils.getAllNews(mContext);
        //2.找到控件
        ListView lv_kouzi = (ListView) mView.findViewById(R.id.list_kouzi);
        //3.创建一个adapter设置给listview
        KouziAdapter kouziAdapter = new KouziAdapter(mContext, allNews);
        lv_kouzi.setAdapter(kouziAdapter);
        //4.设置listview条目的点击事件
        lv_kouzi.setOnItemClickListener(this);

        return mView;
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_kouzi_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        //需要获取条目上bean对象中url做跳转
        KouziBean bean = (KouziBean) parent.getItemAtPosition(position);

        String url = bean.kouzi_url;

        //跳转浏览器
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
