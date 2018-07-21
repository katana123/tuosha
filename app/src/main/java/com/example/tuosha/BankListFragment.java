package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.ImsXuanMixloanProductEntity;
import com.example.tuosha.model.SWbean;



import java.util.ArrayList;

import static com.example.tuosha.client.CustomApplication.getInstance;

//import com.example.R;

@SuppressLint("ValidFragment")
public class BankListFragment extends Fragment implements AdapterView.OnItemClickListener{

    private View mView;

    private TextView title;
    private ProgressDialog dialog;
    private Context mContext;
    private Thread mThread;

    private CustomApplication customApplication;
    private FragmentManager fManager;
    private ArrayList<BankBean> datas;
    private String txt_title;

    //   @SuppressLint("ValidFragment")
//    public BankListFragment(FragmentManager fManager, ArrayList<BankBean> datas) {
//        this.fManager = fManager;
//        this.datas = datas;
//    }
    @SuppressLint("ValidFragment")
    public BankListFragment(FragmentManager fManager, String txt_title) {
        this.fManager = fManager;
        this.txt_title = txt_title;
    }




    // @Nullable
    // @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.fragment_bank_list, null);

        sendmessage();

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
                    ArrayList<ImsXuanMixloanProductEntity> bankList = new ArrayList<ImsXuanMixloanProductEntity>();
                    CustomApplication application = (CustomApplication)getInstance();
                    mContext = getActivity();
                    if (customApplication.getProductEntityArrayList() != null) {
                        ArrayList<BankBean> allNews = BankUtils.getAllNews(mContext, customApplication.getProductEntityArrayList());
                        //3.创建一个adapter
                        BankAdapter  bankAdapter = new BankAdapter(mContext, allNews);
                        //4.设置给listview
                        ListView lv_bank = (ListView) mView.findViewById(R.id.lv_bank);
                        lv_bank.setAdapter(bankAdapter);
                        bankAdapter.notifyDataSetChanged();//一旦适配器有数据，直接通知listView更新
                        lv_bank.setOnItemClickListener(BankListFragment.this);
                        application.setProductEntityArrayList(null);
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





    //6.listview的条目点击时会调用该方法   parent:代表listviw  view:点击的条目上的那个view对象   position:条目的位置  id： 条目的id
    //@Override
//    public void onItemClick(AdapterView<?> parent, View view, int position,
//                            long id) {
//
//        //需要获取条目上bean对象中url做跳转
//        BankBean bean = (BankBean) parent.getItemAtPosition(position);
//        String url = bean.bank_url;
//        String name = bean.title;
//        String apply_num = bean.clicknum;
//        String des = bean.des;
//        String logo = bean.icon;
//        fManager = getFragmentManager();
//        FragmentTransaction fTransaction = fManager.beginTransaction();
//        CardContentFragment ncFragment = new CardContentFragment(fManager,"提额通道");
//        Bundle bd = new Bundle();
//        // bd.putString("content", datas.get(position).getDes());
//        bd.putString("name",name);
//        bd.putString("url",url);
//        bd.putString("logo",logo);
//        bd.putString("des",des);
//        bd.putString("apply_num",apply_num);
//        ncFragment.setArguments(bd);
//        //获取Activity的控件
//        //bar_title
//        //TextView txt_title = (TextView) getActivity().findViewById(R.id.bank_title);
//        //txt_title.setText("银行贷款");
//
//
//        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
//        fTransaction.replace(R.id.fl_bank, ncFragment);
//        //调用addToBackStack将Fragment添加到栈中
//        fTransaction.addToBackStack(null);
//        fTransaction.commit();
//
//    }
    @SuppressLint("ResourceType")
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        BankBean bean = (BankBean) adapterView.getItemAtPosition(position);

        String url = bean.bank_url;
        fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        BankWebFragment ncFragment = new BankWebFragment();
        Bundle bd = new Bundle();

        bd.putString("url", url);
        ncFragment.setArguments(bd);

        fTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fTransaction.replace(R.id.fl_card, ncFragment);
        //调用addToBackStack将Fragment添加到栈中
        fTransaction.addToBackStack(null);
        fTransaction.commit();
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
                    swbean.setCommand(Constants.BANKLIST);
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
                    ArrayList<ImsXuanMixloanProductEntity> bankList = new ArrayList<ImsXuanMixloanProductEntity>();
                    //CustomApplication customApplication = new CustomApplication();

                    customApplication=(CustomApplication) getInstance();
                    Thread.sleep(5000);
                    System.out.println("customApplication的内容 :" +customApplication.getProductEntityArrayList());
                    //System.out.println("bukenengqudao :" +customApplication.getMailusername());
                    int i=0;
                    while (customApplication.getProductEntityArrayList()==null){
                        //while (customApplication.getMailusername()==null){
                        i=i+1;
                        System.out.println("du"+customApplication.getProductEntityArrayList());
                        Thread.sleep(1000 );
                        if (i>50) break;
                    }
                    if (i<50){
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
    // @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // TODO Auto-generated method stub
        if(firstVisibleItem+visibleItemCount==totalItemCount)
        {
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


}