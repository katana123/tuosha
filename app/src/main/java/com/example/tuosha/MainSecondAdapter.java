package com.example.tuosha;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.model.ContentBean;

import java.io.File;
import java.util.ArrayList;

public class MainSecondAdapter extends BaseAdapter {
    private ArrayList<ContentBean> list;
    private Context context;

    public MainSecondAdapter(ArrayList<ContentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //1.复用converView优化listview,创建一个view作为getview的返回值用来显示一个条目
        if(convertView != null){
            view = convertView;
        }else {
            //方法一：推荐
            //context:上下文, resource:要转换成view对象的layout的id, root:将layout用root(ViewGroup)包一层作为codify的返回值,一般传null
            view = View.inflate(context, R.layout.main_second_layout, null);//将一个布局文件转换成一个view对象

            //方法二
            //通过LayoutInflater将布局转换成view对象
            //view =  LayoutInflater.from(context).inflate(R.layout.item_news_layout, null);

            //方法三：系统级开发
            //通过context获取系统服务得到一个LayoutInflater，通过LayoutInflater将一个布局转换为view对象
            //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //view = layoutInflater.inflate(R.layout.item_news_layout, null);

        }
        //2.获取view上的子控件对象
        ImageView item_img_icon = view.findViewById(R.id.item_img_icon);
        TextView item_tv_des = view.findViewById(R.id.item_tv_des);
        TextView item_tv_title = view.findViewById(R.id.item_tv_title);
        TextView item_tv_date = view.findViewById(R.id.pub_time);
        TextView read_count = view.findViewById(R.id.read_count);
        //3.获取postion位置条目对应的list集合中的新闻数据，Bean对象
        ContentBean contentBean = list.get(position);
        //4.将数据设置给这些子控件做显示
//        item_img_icon.setImageDrawable(contentBean.icon);//设置imageView的图片
        item_tv_title.setText(contentBean.title);
        item_tv_des.setText(contentBean.des);
        item_tv_date.setText(contentBean.newstime);
        read_count.setText(contentBean.readnum);
        if (contentBean.icon == "") {
            item_img_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.quick_option_note_over));//设置imageView的图片
        } else {
            if (!fileIsExists(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + contentBean.icon)) {
                item_img_icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.quick_option_note_over));
            } else {
                item_img_icon.setImageURI(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + contentBean.icon)));
            }
        }
        return view;
    }

    public boolean fileIsExists(String strFile) {
        try {
            File f = new File(strFile);
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
