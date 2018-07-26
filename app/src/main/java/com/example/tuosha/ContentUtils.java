package com.example.tuosha;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.PostsEntity;


public class ContentUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<PostsEntity> getAllNews(Context context, ArrayList<PostsEntity> postsEntities) {

        ArrayList<PostsEntity> arrayList = new ArrayList<PostsEntity>();

        if (postsEntities != null) {
            for (int i = 0; i < 10; i++) {
                try {
                    PostsEntity postsEntity = new PostsEntity();
                    postsEntity.name = postsEntities.get(i).getName();
                    postsEntity.id = postsEntities.get(i).getId();
                    postsEntity.intro = postsEntities.get(i).getIntro();
                    postsEntity.createdAt = postsEntities.get(i).getCreatedAt();
                    postsEntity.views = postsEntities.get(i).getViews();
                    postsEntity.image = postsEntities.get(i).getImage();
                    arrayList.add(postsEntity);
                } catch (Exception e) {

                    break;
                }
            }
        }
        return arrayList;
    }

}
