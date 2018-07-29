package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.Utils.DialogUtils;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.JieQiansEntity;
import com.example.tuosha.model.KouziBean;
import com.example.tuosha.model.SWbean;

import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;

import static com.example.tuosha.client.CustomApplication.getInstance;

@SuppressLint("ValidFragment")
public class KouziListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private View mView;
    private int kouziId;
    private FragmentManager fManager;
    private ArrayList<KouziBean> datas;
    private ListView list_news;
    private String txt_title;
    private Context mContext;
    private CustomApplication customApplication;
    private ScheduledExecutorService scheduledExecutorService;
    private WebView webView;
    private Thread mThread;
    private Dialog mDialog;

    public KouziListFragment() {
    }

    @SuppressLint("ValidFragment")
    public KouziListFragment(FragmentManager fManager, String txt_title, int kouziId) {
        this.fManager = fManager;
        this.txt_title = txt_title;
        this.kouziId = kouziId;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_kouzi_list, container, false);
        mContext = getActivity();
        mDialog = DialogUtils.createLoadingDialog(mContext, Constants.LOADING_DATA);
        getSecondKouziList(kouziId);
        receivemsg();

        ListView lv_kouzi = mView.findViewById(R.id.list_kouzi);
        lv_kouzi.setOnItemClickListener(this);
        return mView;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mContext = getActivity();
            switch (msg.what) {
                case 200:
                    ArrayList<JieQiansEntity> contentBeans = new ArrayList<JieQiansEntity>();
                    CustomApplication application = (CustomApplication) getInstance();

                    DialogUtils.closeDialog(mDialog);
                    if (application.getJieQiansEntities() != null) {
                        ArrayList<JieQiansEntity> allNews = KouziUtils.getAllNews(mContext, application.getJieQiansEntities());
                        //3.创建一个adapter
                        KouziListAdapter contentAdapter = new KouziListAdapter(mContext, allNews);
                        //4.设置给listview
                        ListView lv_news = mView.findViewById(R.id.list_kouzi);
                        lv_news.setAdapter(contentAdapter);
                        contentAdapter.notifyDataSetChanged();//一旦适配器有数据，直接通知listView更新
                        lv_news.setOnItemClickListener(KouziListFragment.this);
                        application.setJieQiansEntities(null);
                    }

                    break;
                case -1:
                    //获取失败
                    DialogUtils.closeDialog(mDialog);
//                    Toast.makeText(mContext, "获取失败", Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    //获取发生异常
                    DialogUtils.closeDialog(mDialog);
//                    Toast.makeText(mContext, "获取发生异常", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    //其他情况
//                    Toast.makeText(mContext, "获取发生异常", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void getSecondKouziList(final int kouziId) {
        Thread thread = new Thread() {
            public void run() {
                CustomApplication customApplication = new CustomApplication();
                try {
                    IMCGClientHandler nettyClientHandler = new IMCGClientHandler(customApplication);
                    nettyClientHandler.start();
                    SWbean sWbean = new SWbean();
                    sWbean.setCommand(Protocols.KOUZISECONDLIST);
                    sWbean.setKouziType(kouziId);
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
                    ArrayList<JieQiansEntity> bankList = new ArrayList<JieQiansEntity>();
                    //CustomApplication customApplication = new CustomApplication();

                    customApplication = (CustomApplication) getInstance();
                    Thread.sleep(5000);
                    System.out.println("customApplication的内容 :" + customApplication.getJieQiansEntities());
                    //System.out.println("bukenengqudao :" +customApplication.getMailusername());
                    int i = 0;
                    while (customApplication.getJieQiansEntities() == null) {
                        //while (customApplication.getMailusername()==null){
                        i = i + 1;
                        System.out.println("du" + customApplication.getJieQiansEntities());
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

                    }
                };
                mThread.start();
            }
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        JieQiansEntity bean = (JieQiansEntity) parent.getItemAtPosition(position);

        String url = bean.link;
        System.out.println(url + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        webView = new WebView(getActivity());
        webView.setWebViewClient(new WebViewClient() {
            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);  //设置WebView属性,运行执行js脚本
        webView.loadUrl(url);          //调用loadUrl方法为WebView加入链接
        getActivity().setContentView(webView);
    }

}
