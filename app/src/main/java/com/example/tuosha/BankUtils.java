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
import com.example.tuosha.model.TiEsEntity;


import java.util.ArrayList;


public class BankUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<BankBean> getAllNews(Context context ,ArrayList<TiEsEntity> bankList) {

        ArrayList<BankBean> arrayList = new ArrayList<BankBean>();

        for(int i = 0 ;i <bankList.size();i++)
        {

            BankBean bankBean = new BankBean();

            bankBean.title =bankList.get(i).getName();

            bankBean.bank_url= bankList.get(i).getLink();
            if ((bankList.get(i).getImage()==null) || (bankList.get(i).getImage()=="")) {
                bankBean.icon = "";
            }else{
                bankBean.icon = bankList.get(i).getImage();
            }
                // bankBean.icon =//json.getString("logo");
            arrayList.add(bankBean);



        }
        return arrayList;
    }

}
