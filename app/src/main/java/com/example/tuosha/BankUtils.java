package com.example.tuosha;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;


public class BankUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<BankBean> getAllNews(Context context) {

        ArrayList<BankBean> arrayList = new ArrayList<BankBean>();

        for(int i = 0 ;i <10;i++)
        {
            BankBean bankBean = new BankBean();
            bankBean.title ="上海银行";
            bankBean.des= "搜索算法似懂非懂三分得手房贷首付第三方的手";
            bankBean.bank_url= "http://www.sina.cn";
            bankBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(bankBean);


            BankBean bankBean1 = new BankBean();
            bankBean1.title ="似懂非懂瑟瑟发抖速度";
            bankBean1.des= "地方上的房贷首付读书首付第三方的手房贷首付第三方的手负担";
            bankBean1.bank_url= "http://www.baidu.cn";
            bankBean1.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_photo_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(bankBean1);



            BankBean bankBean2 = new BankBean();
            bankBean2.title ="豆腐皮人热舞";
            bankBean2.des= "费解的是离开房间打扫李开复离开独守空房迪斯科浪费电锋克劳利分级恐龙快打";
            bankBean2.bank_url= "http://www.qq.com";
            bankBean2.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_scan_over);;//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(bankBean2);
        }
        return arrayList;
    }

}
