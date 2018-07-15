package com.example.tuosha;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//import com.example.R;

//接口
public class BankActivity extends Activity implements AdapterView.OnItemClickListener{

    private View mView;

    private TextView title;

    //5.context
    private Context mContext;

    public BankActivity() {

    }

   // public static BankActivity newInstance() {
    //    BankActivity fragment = new BankActivity();
     //   return fragment;
   // }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);
        //1.获取新闻数据用list封装
        // mContext = getActivity();
        ArrayList<BankBean> allNews = BankUtils.getAllNews(this);
        //2.找到控件
       ListView lv_bank = (ListView) findViewById(R.id.lv_bank);
        //3.创建一个adapter设置给listview
       BankAdapter bankAdapter = new BankAdapter(this, allNews);
        lv_bank.setAdapter(bankAdapter);
        //4.设置listview条目的点击事件
        lv_bank.setOnItemClickListener(this);
    }
   // @Nullable
   // @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.activity_bank, null);
        

       

        //1.获取新闻数据用list封装
       // mContext = getActivity();
       // ArrayList<BankBean> allNews = BankUtils.getAllNews(mContext);
        //2.找到控件
       // ListView lv_bank = (ListView) findViewById(R.id.lv_bank);
        //3.创建一个adapter设置给listview
        //BankAdapter bankAdapter = new BankAdapter(mContext, allNews);
        //lv_bank.setAdapter(bankAdapter);
        //4.设置listview条目的点击事件
       // lv_bank.setOnItemClickListener(this);


        return mView;
    }
  
    
       

   

    
    //6.listview的条目点击时会调用该方法   parent:代表listviw  view:点击的条目上的那个view对象   position:条目的位置  id： 条目的id
    //@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        //需要获取条目上bean对象中url做跳转
        BankBean bean = (BankBean) parent.getItemAtPosition(position);

        String url = bean.bank_url;

        //跳转浏览器
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}