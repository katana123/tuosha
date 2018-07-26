package com.example.tuosha;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.cache.ImageLoader;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.model.PostsEntity;


public class ContentAdapter extends BaseAdapter{

    private List<PostsEntity> mList;
    private LayoutInflater mInflater;
    private ImageLoader mImageLoader;

    //通过构造方法接受要显示的新闻数据集合
    public ContentAdapter(Context context, List<PostsEntity> data) {
        mList = data;
        mInflater = LayoutInflater.from(context);
        mImageLoader = new ImageLoader();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContentAdapter.ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ContentAdapter.ViewHolder();
            view = mInflater.inflate(R.layout.item_news_layout, null);
            viewHolder.item_img_icon = view.findViewById(R.id.item_img_icon);
            viewHolder.item_tv_title = view.findViewById(R.id.item_tv_title);
            viewHolder.item_tv_des = view.findViewById(R.id.item_tv_des);
            viewHolder.item_tv_newstime = view.findViewById(R.id.item_tv_newstime);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ContentAdapter.ViewHolder) view.getTag();
        }
        viewHolder.item_img_icon.setImageResource(R.mipmap.ic_launcher);
        String url = mList.get(i).image;
        viewHolder.item_img_icon.setTag(url);
//        mImageLoader.showImageByThread(viewHolder.item_img_icon,mList.get(i).image);
        viewHolder.item_tv_title.setText(mList.get(i).name);
        viewHolder.item_tv_des.setText(mList.get(i).intro);
        viewHolder.item_tv_newstime.setText(mList.get(i).createdAt + "  |  " + mList.get(i).views + "人在看");
        return view;
    }

    class ViewHolder {
        public ImageView item_img_icon;
        public TextView item_tv_des, item_tv_title, item_tv_newstime;
    }

}
