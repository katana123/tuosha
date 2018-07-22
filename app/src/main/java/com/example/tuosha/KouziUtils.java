package com.example.tuosha;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.model.KouziBean;

import java.util.ArrayList;


public class KouziUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<KouziBean> getAllNews(Context context, ArrayList<KouziBean> kouziList) {

        ArrayList<KouziBean> arrayList = new ArrayList<KouziBean>();

        if (kouziList != null) {
            for (int i = 0; i < 10; i++) {
                try {
                    KouziBean kouziBean = new KouziBean();
                    kouziBean.title = kouziList.get(i).getTitle();
                    kouziBean.clicknum = kouziList.get(i).getClicknum();
                    kouziBean.des = kouziList.get(i).getDes();
                    //处理ext_info
                    String jsonstr = kouziList.get(i).getExtInfo();
                    JSONObject jobject = JSON.parseObject(jsonstr);
//                    kouziBean.extInfo = jobject.getString("content");
                    if ((jobject.getString("logo") == null) || (jobject.getString("logo") == "")) {
                        kouziBean.icon = "";
                    } else {
                        kouziBean.icon = jobject.getString("logo");
                    }
                    kouziBean.kouzi_url = jobject.getString("url");
                    kouziBean.kouzitime = kouziList.get(i).getKouzitime();
                    kouziBean.extInfo = kouziList.get(i).getExtInfo();
                    // cardBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
                    arrayList.add(kouziBean);
                } catch (Exception e) {

                    break;
                }
            }
        }
        return arrayList;
    }

}
