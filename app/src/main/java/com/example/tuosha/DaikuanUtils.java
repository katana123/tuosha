package com.example.tuosha;

import android.content.Context;

import com.example.tuosha.model.DaikuansEntity;
import com.example.tuosha.model.XinYongKasEntity;

import java.util.ArrayList;


public class DaikuanUtils {

    //封装新闻的假数据到list中返回,以后数据会从数据库中获取
    public static ArrayList<CardBean> getAllNews(Context context, ArrayList<DaikuansEntity> cardList) {

        ArrayList<CardBean> arrayList = new ArrayList<CardBean>();
        if (cardList !=null ) {
            for (int i = 0; i < 10; i++) {
                try {
                    CardBean cardBean = new CardBean();
                    cardBean.title = cardList.get(i).getName();
                    cardBean.card_url = cardList.get(i).getLink();
                    if ((cardList.get(i).getImage() == null) || (cardList.get(i).getImage()  == "")) {
                        cardBean.icon = "";
                    } else {
                        cardBean.icon = cardList.get(i).getImage() ;
                    }
                    // cardBean.icon = ContextCompat.getDrawable(context, R.drawable.quick_option_note_over); //通过context对象将一个资源id转换成一个Drawable对象。
                    arrayList.add(cardBean);
                }catch(Exception e){

                    break;
                }
            }
        }
        return arrayList;
    }

}
