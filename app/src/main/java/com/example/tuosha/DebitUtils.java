package com.example.tuosha;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;
import com.example.tuosha.model.ProcessesEntity;
import com.example.tuosha.model.SWbean;


import java.util.ArrayList;


public class DebitUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<DebitBean> getAllNews(Context context ,ArrayList<ProcessesEntity> debitList) {

        ArrayList<DebitBean> arrayList = new ArrayList<DebitBean>();

        //List<User> userList = JSON.parseArray(userInfoJson,User.class);
        //JSONObject interactiveSignVos = JSON.parseObject(userInfoJson);
        if (debitList !=null ) {
        for(int i = 0 ;i <debitList.size();i++) {
            //JSONObject job = jsonArray.getJSONObject(i);
            DebitBean debitBean = new DebitBean();

            debitBean.title = debitList.get(i).getName();
            debitBean.debit_url = debitList.get(i).getLink();
            if ((debitList.get(i).getImage() == null) || (debitList.get(i).getImage()  == "")) {
                debitBean.icon = "";
            } else {
                debitBean.icon = debitList.get(i).getImage() ;
            }
            // bankBean.icon =//json.getString("logo");
            arrayList.add(debitBean);


        }
        }
        return arrayList;
    }

}
