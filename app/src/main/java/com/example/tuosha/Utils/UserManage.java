package com.example.tuosha.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.tuosha.model.TbUsersEntity;
import com.example.tuosha.model.UsersEntity;
import com.example.tuosha.model.XinYongKasEntity;

public class UserManage {

    private static UserManage instance;

    private UserManage() {
    }

    public static UserManage getInstance() {
        if (instance == null) {
            instance = new UserManage();
        }
        return instance;
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveUserInfo(Context context, String username, String password,String phone,String Status) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NAME", username);
        editor.putString("PASSWORD", password);
        editor.putString("PHONE", phone);
        editor.putString("STATUS", password);
        editor.commit();
    }
    public void saveBankCardInfo(Context context, String name, String url,String logo,String des,String apply_num) {
        SharedPreferences sp = context.getSharedPreferences("bankCardInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("NAME", name);
        editor.putString("url", url);
        editor.putString("logo", logo);
        editor.putString("des", des);
        editor.putString("apply_num", apply_num);
        editor.commit();
    }

    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public UsersEntity getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        UsersEntity userInfo = new UsersEntity();
        userInfo.setNickname(sp.getString("USER_NAME", ""));
        userInfo.setPassword(sp.getString("PASSWORD", ""));
        return userInfo;
    }
    public XinYongKasEntity getBankCardInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("bankcardInfo", Context.MODE_PRIVATE);
        XinYongKasEntity bankCardInfo = new XinYongKasEntity();
        bankCardInfo.setName(sp.getString("NAME", ""));
        bankCardInfo.setLink(sp.getString("url", ""));
        bankCardInfo.setImage(sp.getString("logo", ""));
        bankCardInfo.setAdvantage(sp.getString("des", ""));
        bankCardInfo.setViews(Integer.getInteger(sp.getString("apply_num", "")));

        return bankCardInfo;
    }

    /**
     * userInfo中是否有数据
     */

    public boolean hasBankCardInfo(Context context) {
        UsersEntity userInfo = getUserInfo(context);
        if (userInfo != null) {
            if ((!TextUtils.isEmpty(userInfo.getNickname())) && (!TextUtils.isEmpty(userInfo.getPassword()))) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean hasUserInfo(Context context) {
        XinYongKasEntity userInfo = getBankCardInfo(context);
        if (userInfo != null) {
            if ((!TextUtils.isEmpty(userInfo.getName())) && (!TextUtils.isEmpty(userInfo.getLink()))) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
