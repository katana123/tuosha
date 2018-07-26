package com.example.tuosha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.cache.ImageLoader;
import com.example.tuosha.model.JieQiansEntity;

import java.util.List;

public class KouziListAdapter extends BaseAdapter {

    private List<JieQiansEntity> mList;
    private LayoutInflater mInflater;
    private ImageLoader mImageLoader;

    public KouziListAdapter(Context context, List<JieQiansEntity> data) {
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
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.item_kouzi_layout, null);
            viewHolder.item_img_icon = view.findViewById(R.id.item_img_kouziicon);
            viewHolder.item_tv_title = view.findViewById(R.id.item_tv_kouzititle);
            viewHolder.item_tv_des = view.findViewById(R.id.item_tv_kouzides);
            viewHolder.item_tv_kouzitime = view.findViewById(R.id.item_tv_kouzitime);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
//        viewHolder.item_img_icon.setImageResource(R.mipmap.ic_launcher);
        String url = mList.get(i).image;
        viewHolder.item_img_icon.setTag(url);
        mImageLoader.showImageByThread(viewHolder.item_img_icon, mList.get(i).image);
        viewHolder.item_tv_title.setText(mList.get(i).name);
        viewHolder.item_tv_des.setText("已申请人数" + mList.get(i).view + "人");
        viewHolder.item_tv_kouzitime.setText(mList.get(i).createdAt + "  |  " + mList.get(i).view + "人在看");
        return view;
    }

    class ViewHolder {
        public ImageView item_img_icon;
        public TextView item_tv_des, item_tv_title, item_tv_kouzitime;
    }
}
