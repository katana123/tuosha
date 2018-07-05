package com.example.tuosha;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;


public class KouziUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<KouziBean> getAllNews(Context context) {

        ArrayList<KouziBean> arrayList = new ArrayList<KouziBean>();

        for(int i = 0 ;i <10;i++)
        {
            KouziBean kouziBean = new KouziBean();
            kouziBean.title ="火箭发射成功";
            kouziBean.des= "搜索算法似懂非懂三分得手房贷首付第三方的手";
            kouziBean.kouzi_url= "http://www.sina.cn";
            kouziBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(kouziBean);


            KouziBean kouziBean1 = new KouziBean();
            kouziBean1.title ="似懂非懂瑟瑟发抖速度";
            kouziBean1.des= "地方上的房贷首付读书首付第三方的手房贷首付第三方的手负担";
            kouziBean1.kouzi_url= "http://www.baidu.cn";
            kouziBean1.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_photo_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(kouziBean1);



            KouziBean kouziBean2 = new KouziBean();
            kouziBean2.title ="豆腐皮人热舞";
            kouziBean2.des= "费解的是离开房间打扫李开复离开独守空房迪斯科浪费电锋克劳利分级恐龙快打";
            kouziBean2.kouzi_url= "http://www.qq.com";
            kouziBean2.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_scan_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(kouziBean2);
        }
        return arrayList;
    }

}
