package com.example.tuosha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.INFOCOLT;
import com.example.tuosha.model.SWbean;
import com.example.tuosha.netty.CustomApplication;
import com.example.tuosha.netty.NettyClientHandler;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static com.example.tuosha.netty.CustomApplication.getInstance;

@SuppressLint("ValidFragment")
public class ArticleListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View mView;
    private FragmentManager fManager;
    private ArrayList<ContentBean> datas;
    private ListView list_news;
    private String erTitle;
    private int jisuId;
    private Context mContext;
    private CustomApplication customApplication;
    private Thread mThread;

    public ArticleListFragment() {
    }

    @SuppressLint("ValidFragment")
    public ArticleListFragment(FragmentManager fManager, String erTitle, int jisuId) {
        this.fManager = fManager;
        this.erTitle = erTitle;
        this.jisuId = jisuId;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fg_articlelist, container, false);
        sendmessage(jisuId);

        System.out.println("执行receive");
        receivemsg();


        return mView;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 200:
                    ArrayList<ContentBean> contentBeans = new ArrayList<ContentBean>();
                    CustomApplication application = (CustomApplication) getInstance();
                    mContext = getActivity();
                    if (customApplication.getContentSecondList() != null) {
                        ArrayList<ContentBean> allNews = ContentUtils.getAllNews(mContext, customApplication.getContentSecondList());
                        //3.创建一个adapter
                        ContentAdapter contentAdapter = new ContentAdapter(mContext, allNews);
                        //4.设置给listview
                        ListView lv_news = mView.findViewById(R.id.list_article);
                        lv_news.setAdapter(contentAdapter);
                        contentAdapter.notifyDataSetChanged();//一旦适配器有数据，直接通知listView更新
                        lv_news.setOnItemClickListener(ArticleListFragment.this);
                        application.setContentSecondList(null);
                    }

                    break;
                case -1:
                    //获取失败
                    Toast.makeText(mContext, "获取失败", Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    //获取发生异常
                    Toast.makeText(mContext, "获取发生异常", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    //其他情况
                    Toast.makeText(mContext, "获取发生异常", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void sendmessage(final int jisuId) {
        Thread thread = new Thread() {
            public void run() {
                CustomApplication customApplication = new CustomApplication();

                try {
                    NettyClientHandler nettyClientHandler = new NettyClientHandler(customApplication);
                    nettyClientHandler.start();
                    INFOCOLT sWbean = new INFOCOLT();
                    sWbean.setCommand(Protocols.CONTENTLISTBYID);
                    sWbean.setJisuType(jisuId);
                    Thread.sleep(1000 * 3);
                    nettyClientHandler.sendMsg(sWbean);
                    Thread.sleep(1000);
                    nettyClientHandler.disposeInfoColClient();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void receivemsg() {
        System.out.println("执行接收程序");


        new Thread() {
            @Override
            public void run() {
                super.run();
                JSONArray aaa = new JSONArray();
                try {
                    ArrayList<ContentBean> bankList = new ArrayList<ContentBean>();
                    //CustomApplication customApplication = new CustomApplication();

                    customApplication = (CustomApplication) getInstance();
                    Thread.sleep(5000);
                    System.out.println("customApplication的内容 :" + customApplication.getContentSecondList());
                    //System.out.println("bukenengqudao :" +customApplication.getMailusername());
                    int i = 0;
                    while (customApplication.getContentSecondList() == null) {
                        //while (customApplication.getMailusername()==null){
                        i = i + 1;
                        System.out.println("du" + customApplication.getContentSecondList());
                        Thread.sleep(1000);
                        if (i > 50) break;
                    }
                    if (i < 50) {
                        Message message = new Message();
                        message.what = 200; //200代码获取数据正常
                        handler.sendMessage(message);

                    } else {
                        Message message = new Message();
                        message.what = -1; //代码获取数据 常
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

    // @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        if (firstVisibleItem + visibleItemCount == totalItemCount) {
            //开线程去下载网络数据
            if (mThread == null || !mThread.isAlive()) {
                mThread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            //这里放你网络数据请求的方法，我在这里用线程休眠5秒方法来处理
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //handler.sendMessage(message);
                    }
                };
                mThread.start();
            }
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        ContentBean bean = (ContentBean) parent.getItemAtPosition(position);
        String name = bean.title;
        String apply_num = bean.readnum;
        String newstime = bean.newstime;
        String logo = bean.icon;
        int id = bean.id;
        String extInfo = bean.extInfo;

        fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        ArticleContentFragment ncFragment = new ArticleContentFragment(fManager, erTitle);
        Bundle bd = new Bundle();
        // bd.putString("content", datas.get(position).getDes());
        bd.putString("name", name);
        bd.putString("apply_num", apply_num);
        bd.putString("newstime", newstime);
        bd.putString("logo", logo);
        bd.putInt("id", id);
        bd.putString("extInfo", extInfo);
        ncFragment.setArguments(bd);
        //获取Activity的控件
        //bar_title
        TextView txt_title = getActivity().findViewById(R.id.article_title);
        txt_title.setText(name);

        //加上FragmentgetDes替换动画
        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_content, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }
}
