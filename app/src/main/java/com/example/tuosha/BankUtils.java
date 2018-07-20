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
import com.example.tuosha.model.ImsXuanMixloanBankEntity;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;
import com.example.tuosha.model.SWbean;


import java.util.ArrayList;


public class BankUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<BankBean> getAllNews(Context context ,ArrayList<ImsXuanMixloanProductEntity> bankList) {

        ArrayList<BankBean> arrayList = new ArrayList<BankBean>();

        for(int i = 0 ;i <bankList.size();i++)
        {

            BankBean bankBean = new BankBean();

            bankBean.title =bankList.get(i).getName();
            String jsonstr=bankList.get(i).getExtInfo();
            JSONObject jobject = JSON.parseObject(jsonstr);
            bankBean.clicknum = jobject.getString("apply_num");
            bankBean.des= jobject.getString("v_name");
            bankBean.bank_url= jobject.getString("url");
            if ((jobject.getString("logo")==null) || (jobject.getString("logo")=="")) {
                bankBean.icon = "";
            }else{
                bankBean.icon = jobject.getString("logo");
            }
                // bankBean.icon =//json.getString("logo");
            arrayList.add(bankBean);



        }
        return arrayList;
    }

}
