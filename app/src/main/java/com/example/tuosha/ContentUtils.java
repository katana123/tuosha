package com.example.tuosha;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.content.ContextCompat;


public class ContentUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<ContentBean> getAllNews(Context context) {

        ArrayList<ContentBean> arrayList = new ArrayList<ContentBean>();

        for(int i = 0 ;i <10;i++)
        {
            ContentBean contentBean = new ContentBean();
            contentBean.title ="火箭发射成功";
            contentBean.des= "搜索算法似懂非懂三分得手房贷首付第三方的手";
            contentBean.news_url= "http://www.sina.cn";
            contentBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(contentBean);


            ContentBean contentBean1 = new ContentBean();
            contentBean1.title ="似懂非懂瑟瑟发抖速度";
            contentBean1.des= "地方上的房贷首付读书首付第三方的手房贷首付第三方的手负担";
            contentBean1.news_url= "http://www.baidu.cn";
            contentBean1.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_photo_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(contentBean1);



            ContentBean contentBean2 = new ContentBean();
            contentBean2.title ="豆腐皮人热舞";
            contentBean2.des= "费解的是离开房间打扫李开复离开独守空房迪斯科浪费电锋克劳利分级恐龙快打";
            contentBean2.news_url= "http://www.qq.com";
            contentBean2.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_scan_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(contentBean2);
        }
        return arrayList;
    }

}
