package com.example.tuosha;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.model.JqCatsEntity;
import com.example.tuosha.model.KouziBean;

import java.util.ArrayList;


public class KouziUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<JieQiansEntity> getAllNews(Context context, ArrayList<JieQiansEntity> JieQiansEntities) {

        ArrayList<JieQiansEntity> arrayList = new ArrayList<JieQiansEntity>();

        if (JieQiansEntities != null) {
            for (int i = 0; i < 10; i++) {
                try {
                    JieQiansEntity jieQiansEntity = new JieQiansEntity();
                    jieQiansEntity.name = JieQiansEntities.get(i).getName();
                    jieQiansEntity.advantage = JieQiansEntities.get(i).getAdvantage();
                    jieQiansEntity.view = JieQiansEntities.get(i).getView();
                    jieQiansEntity.id = JieQiansEntities.get(i).getId();
                    jieQiansEntity.createdAt = JieQiansEntities.get(i).getCreatedAt();
                    jieQiansEntity.link = JieQiansEntities.get(i).getLink();
                    jieQiansEntity.image = JieQiansEntities.get(i).getImage();
                    arrayList.add(jieQiansEntity);
                } catch (Exception e) {

                    break;
                }
            }
        }
        return arrayList;
    }

}
