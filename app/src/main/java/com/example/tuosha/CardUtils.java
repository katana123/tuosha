package com.example.tuosha;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;


public class CardUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<CardBean> getAllNews(Context context) {

        ArrayList<CardBean> arrayList = new ArrayList<CardBean>();

        for(int i = 0 ;i <10;i++)
        {
            CardBean cardBean = new CardBean();
            cardBean.title ="火箭发射成功";
            cardBean.des= "搜索算法似懂非懂三分得手房贷首付第三方的手";
            cardBean.card_url= "http://www.sina.cn";
            cardBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(cardBean);


            CardBean cardBean1 = new CardBean();
            cardBean1.title ="似懂非懂瑟瑟发抖速度";
            cardBean1.des= "地方上的房贷首付读书首付第三方的手房贷首付第三方的手负担";
            cardBean1.card_url= "http://www.baidu.cn";
            cardBean1.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_photo_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(cardBean1);



            CardBean cardBean2 = new CardBean();
            cardBean2.title ="豆腐皮人热舞";
            cardBean2.des= "费解的是离开房间打扫李开复离开独守空房迪斯科浪费电锋克劳利分级恐龙快打";
            cardBean2.card_url= "http://www.qq.com";
            cardBean2.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_scan_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(cardBean2);
        }
        return arrayList;
    }

}
