package com.example.tuosha;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.model.ContentBean;


public class ContentUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<ContentBean> getAllNews(Context context, ArrayList<ContentBean> contentList) {

        ArrayList<ContentBean> arrayList = new ArrayList<ContentBean>();

        if (contentList != null) {
            for (int i = 0; i < 10; i++) {
                try {
                    ContentBean contentBean = new ContentBean();
                    contentBean.title = contentList.get(i).getTitle();
                    contentBean.readnum = contentList.get(i).getReadnum();
                    contentBean.newstime = contentList.get(i).getNewstime();
                    //处理ext_info
                    String jsonstr = contentList.get(i).getExtInfo();
                    JSONObject jobject = JSON.parseObject(jsonstr);
                    contentBean.extInfo = jobject.getString("content");
                    if ((jobject.getString("pic") == null) || (jobject.getString("pic") == "")) {
                        contentBean.icon = "";
                    } else {
                        contentBean.icon = jobject.getString("pic");
                    }
                    // cardBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
                    arrayList.add(contentBean);
                } catch (Exception e) {

                    break;
                }
            }
        }
        return arrayList;
    }

}
