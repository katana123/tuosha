package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.Utils.CacheUtil;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.Utils.DialogUtils;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.DaikuansEntity;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.model.TiEsEntity;

import java.util.ArrayList;

import static com.example.tuosha.client.CustomApplication.getInstance;

@SuppressLint("ValidFragment")
public class CardListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private FragmentManager fManager;
    private ArrayList<CardBean> datas;
    private ListView list_news;
    private String txt_title;
    private Context mContext;
    private ViewPager mViewPaper;
    private int currentItem;
    private View mview;
    private CacheUtil util;
    private Dialog mDialog;

    @SuppressLint("ValidFragment")
    public CardListFragment(FragmentManager fManager, ArrayList<CardBean> datas) {
        this.fManager = fManager;
        this.datas = datas;
    }
    @SuppressLint("ValidFragment")
    public CardListFragment(FragmentManager fManager, String txt_title) {
        this.fManager = fManager;
        this.txt_title = txt_title;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_card_list, container, false);
        util = CacheUtil.getInstance();

        mContext = getActivity();
        mDialog = DialogUtils.createLoadingDialog(mContext, Constants.LOADING_DATA);
        setData();

        return mview;
    }


    /**
     * 接收子线程传递过来的数据
     */
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            //mViewPaper.setCurrentItem(currentItem);
            mContext = getActivity();
            switch (msg.what){
                case 200:
                    //ArrayList<ImsXuanMixloanBankCardEntity> cardList = new ArrayList<ImsXuanMixloanBankCardEntity>();
                    CustomApplication application = (CustomApplication)getInstance();
                    if (application.getDaikuansEntities() != null) {

                        DialogUtils.closeDialog(mDialog);
                        ArrayList<CardBean> allNews = DaikuanUtils.getAllNews(mContext, application.getDaikuansEntities());

                        //3.创建一个adapter设置给listview
                        ListView lv_debit = mview.findViewById(R.id.lv_card);
                        DaikuanAdapter daikuanAdapter = new DaikuanAdapter(getActivity(), allNews);
                        lv_debit.setAdapter(daikuanAdapter);
                        lv_debit.setOnItemClickListener(CardListFragment.this);
                        application.setDaikuansEntities(null);
                    }
                    break;
                case -1:
                    //获取失败
                    DialogUtils.closeDialog(mDialog);
                    // Toast.makeText(BankActivity.this, "获取失败", Toast.LENGTH_SHORT).show();
                    System.out.println("获取失败");

                    break;
                case -2:
                    //获取发生异常
                    // Toast.makeText(BankActivity.this, "获取发生异常", Toast.LENGTH_SHORT).show();
                    System.out.println("获取发生异常");
                    break;
                default:
                    break;
            }
        }
    };
    public void setData(){
        //1.检查customApplication中是否有数据，有就发消息给handler
        CustomApplication application = (CustomApplication)getInstance();
        if (application.getDaikuansEntities()!=null){
            Message message=new Message();
            message.what=200; //200代码获取数据正常
            handler.sendMessage(message);
        }
        //2.检查customApplication中没有数据，在Lrucache中找有没有数据
        else if (util.getJsonLruCache(3)!=null){

            String jsonLruCache =util.getJsonLruCache(3);
            JSONArray jsonArray = JSON.parseArray(jsonLruCache);
            ArrayList<DaikuansEntity> xykList = new ArrayList<DaikuansEntity>();
            for (Object jsonObject : jsonArray) {
                DaikuansEntity platformModel = JSONObject.parseObject(jsonObject.toString(), DaikuansEntity.class);
                xykList.add(platformModel);
            }
            application.setDaikuansEntities(xykList);
            Message message=new Message();
            message.what=200; //200代码获取数据正常
            handler.sendMessage(message);
            //Bitmap bitmap = CacheUtil.getBitmapLruCache(mListId.get(arg2));
        }
        //3.cache中没有数据，向数据库发出请求
        else{
            application.setTiEsEntities(null);
            sendmessage();
            receivemsg();
        }
    }
    public void sendmessage(){
        Thread thread = new Thread() {
            public void run() {
                CustomApplication customApplication=new CustomApplication();
                try {
                    IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
                    imcgClientHandler.start();
                    SWbean swbean = new SWbean();
                    System.out.println("sendmessage");
                    swbean.setCommand(Constants.DAIKUANLIST);
                    Thread.sleep(1000 * 3);
                    imcgClientHandler.sendMsg(swbean);

                    Thread.sleep(1000);
                    imcgClientHandler.disposeInfoColClient();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
    public void receivemsg(){
        System.out.println("执行接收程序");


        new Thread(){
            @Override
            public void run() {
                super.run();
                JSONArray aaa = new JSONArray();
                try {

                    CustomApplication customApplication = (CustomApplication)getInstance();

                    Thread.sleep(3000);
                    System.out.println("customApplication的内容 :" +customApplication.getDaikuansEntities());

                    int i=0;
                    while (customApplication.getDaikuansEntities()==null){

                        i=i+1;
                        System.out.println("du"+customApplication.getDaikuansEntities());
                        Thread.sleep(1000 );
                        if (i>50) break;
                    }
                    if (i<50){
                        util.addJsonLruCache(3, JSON.toJSONString(customApplication.getDaikuansEntities()));
                        Message message=new Message();
                        message.what=200; //200代码获取数据正常
                        handler.sendMessage(message);

                    }
                    else{
                        Message message=new Message();
                        message.what=-1; //代码获取数据 常
                        handler.sendMessage(message);

                    }


                    //把arraylist 转成 jsonArray
                    // String bbb = JSONArray.toJSONString(bankList);
                    //aaa = JSONArray.parseArray(bbb);


                } catch (Exception e) {
                    e.printStackTrace();


                }
            }
        }.start();


    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        CardBean bean = (CardBean) adapterView.getItemAtPosition(position);
        System.out.println(bean.toString());
        String url = bean.card_url;
        fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        CardWebFragment ncFragment = new CardWebFragment();
        Bundle bd = new Bundle();
        // bd.putString("content", datas.get(position).getDes());

        bd.putString("url", url);
        ncFragment.setArguments(bd);

        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_card, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }
}
