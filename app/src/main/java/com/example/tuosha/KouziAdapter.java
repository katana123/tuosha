package com.example.tuosha;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.cache.ImageLoader;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.model.KouziBean;

import java.io.File;
import java.util.ArrayList;


public class KouziAdapter extends BaseAdapter{

    private ArrayList<JieQiansEntity> list;
    private Context context;

    public ArrayList<JieQiansEntity> getList() {
        return list;
    }

    public void setList(ArrayList<JieQiansEntity> list) {
        this.list = list;
    }

    //通过构造方法接受要显示的数据集合
    public KouziAdapter(Context context, ArrayList<JieQiansEntity> list) {
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
            view = View.inflate(context, R.layout.item_kouzi_layout, null);//将一个布局文件转换成一个view对象

            //方法二
            //通过LayoutInflater将布局转换成view对象
            //view =  LayoutInflater.from(context).inflate(R.layout.item_news_layout, null);

            //方法三：系统级开发
            //通过context获取系统服务得到一个LayoutInflater，通过LayoutInflater将一个布局转换为view对象
            //LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //view = layoutInflater.inflate(R.layout.item_news_layout, null);

        }
        //2.获取view上的子控件对象
        ImageView item_img_icon = view.findViewById(R.id.item_img_kouziicon);
        TextView item_tv_des = view.findViewById(R.id.item_tv_kouzides);
        TextView item_tv_title = view.findViewById(R.id.item_tv_kouzititle);
        TextView item_tv_kouzitime = view.findViewById(R.id.item_tv_kouzitime);
        //3.获取postion位置条目对应的list集合中的新闻数据，Bean对象
        JieQiansEntity jieQianBean = list.get(position);
        //4.将数据设置给这些子控件做显示
        item_tv_title.setText(jieQianBean.name);
        item_tv_des.setText("已申请人数" + jieQianBean.view + "人");
        item_tv_kouzitime.setText(jieQianBean.createdAt + "天前  |  " + jieQianBean.view + "人在看");
        new ImageLoader().showImageByThread(item_img_icon, jieQianBean.image);
        return view;
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE);
        }
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
