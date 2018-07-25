package com.example.tuosha;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import android.util.LruCache;
//import com.example.R;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.tuosha.Utils.CacheUtil;
import com.example.tuosha.Utils.Constants;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.ImsXuanMixloanBankCardEntity;
import com.example.tuosha.model.SWbean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.tuosha.client.CustomApplication.getInstance;

//接口
public class CardActivity extends Fragment implements AdapterView.OnItemClickListener{

    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private CustomApplication customApplication;
    private List<View> dots;
    private int currentItem;
    private ArrayList<Integer> mListId;
    private CacheUtil util;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.mipmap.xxdt_03,
            R.mipmap.xxdt_05,
            R.mipmap.xxdt_07,
            R.mipmap.xxdt_03,
            R.mipmap.xxdt_05,
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "轮播1",
            "轮播2",
            "轮播3",
            "轮播4",
            "轮播5"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    //5.context
    private Context mContext;
    private  ListView lv_card ;
    public CardActivity() {

    }

    public static CardActivity newInstance() {
        CardActivity fragment = new CardActivity();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.activity_card, null);
        util = new CacheUtil();
        //滚动图片
        setView();
        //监听点击事件
        setListener();
        //加载数据
        setData();

        return mView;
    }
    private void setView(){
        mViewPaper = mView.findViewById(R.id.cardpic);

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));

        title = mView.findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.point_enable);
                dots.get(oldPosition).setBackgroundResource(R.drawable.point_disenable);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }
    public void setListener(){
        //设置图标点击事件
        TextView tv0 = mView.findViewById(R.id.textView0);
        tv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity() , BankSecondActivity.class);
                startActivity(intent);
            }
        });
        TextView tv1 = mView.findViewById(R.id.textView1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity() , CardSecondActivity.class);
                startActivity(intent);
            }
        });
        TextView tv2 = mView.findViewById(R.id.textView2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(getActivity() , ProgressSecondActivity.class);
                startActivity(intent);
            }
        });
        //改变图标大小
        initbtn(R.id.textView0,R.drawable.quick_option_album_nor);
        initbtn(R.id.textView1,R.drawable.quick_option_note_nor);
        initbtn(R.id.textView2,R.drawable.quick_option_photo_nor);

        lv_card = mView.findViewById(R.id.lv_card);
        //4.设置listview条目的点击事件
        lv_card.setOnItemClickListener(this);
    }
    public void setData(){
        //1.检查customApplication中是否有数据，有就发消息给handler
        CustomApplication application = (CustomApplication)getInstance();
        if (application.getCardEntityArrayList()!=null){
            Message message=new Message();
            message.what=200; //200代码获取数据正常
            handler.sendMessage(message);
        }
        //2.检查customApplication中没有数据，在Lrucache中找有没有数据
        else if (util.getJsonLruCache(1)!=null){

            String jsonLruCache =util.getJsonLruCache(1) ;
            JSONArray jsonArray = JSON.parseArray(jsonLruCache);
            ArrayList<ImsXuanMixloanBankCardEntity> bankCardList = new ArrayList<ImsXuanMixloanBankCardEntity>();
            for (Object jsonObject : jsonArray) {
                ImsXuanMixloanBankCardEntity platformModel = JSONObject.parseObject(jsonObject.toString(), ImsXuanMixloanBankCardEntity.class);
                bankCardList.add(platformModel);
            }
            application.setCardEntityArrayList(bankCardList);
            Message message=new Message();
            message.what=200; //200代码获取数据正常
            handler.sendMessage(message);
            //Bitmap bitmap = CacheUtil.getBitmapLruCache(mListId.get(arg2));
        }
        //3.cache中没有数据，向数据库发出请求
        else{
            sendmessage();
            receivemsg();
        }
    }
    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    /**
     * 图片轮播任务
     * @author liuyazhuang
     *
     */
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            handler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
            switch (msg.what){
                case 200:
                    ArrayList<ImsXuanMixloanBankCardEntity> cardList = new ArrayList<ImsXuanMixloanBankCardEntity>();
                    CustomApplication application = (CustomApplication)getInstance();
                    if (application.getCardEntityArrayList() != null) {
                        mContext = getActivity();
                         ArrayList<CardBean> allNews = CardUtils.getAllNews(mContext, application.getCardEntityArrayList());

                        //3.创建一个adapter设置给listview
                        CardAdapter cardAdapter = new CardAdapter(getActivity(), allNews);
                        lv_card.setAdapter(cardAdapter);

                        application.setCardEntityArrayList(null);
                    }
                    break;
                case -1:
                    //获取失败
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
    public void sendmessage(){
        Thread thread = new Thread() {
            public void run() {
                CustomApplication customApplication=new CustomApplication();
                try {
                    IMCGClientHandler imcgClientHandler = new IMCGClientHandler(customApplication);
                    imcgClientHandler.start();
                    SWbean swbean = new SWbean();
                    System.out.println("sendmessage");
                    swbean.setCommand(Constants.BANKCARDLIST);
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
                   // ArrayList<ImsXuanMixloanBankCardEntity> cardkList = new ArrayList<ImsXuanMixloanBankCardEntity>();

                    CustomApplication customApplication = (CustomApplication)getInstance();

                    Thread.sleep(5000);
                    System.out.println("customApplication的内容 :" +customApplication.getCardEntityArrayList());

                    int i=0;
                    while (customApplication.getCardEntityArrayList()==null){

                        i=i+1;
                        System.out.println("读取customApplication.getCardEntityArrayList:"+customApplication.getCardEntityArrayList());
                        Thread.sleep(1000 );
                        if (i>50) break;
                    }
                    if (i<50){

                        util.addJsonLruCache(1, customApplication.getCardEntityArrayList().toString());
                        Message message=new Message();
                        message.what=200; //200代码获取数据正常
                        handler.sendMessage(message);

                    }
                    else{
                        Message message=new Message();
                        message.what=-1; //代码获取数据 常
                        handler.sendMessage(message);

                    }

                } catch (Exception e) {
                    e.printStackTrace();


                }
            }
        }.start();
    }
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

    private void initbtn(int tw,int pic){
        //控制登录用户名图标大小
        TextView hpRB = mView.findViewById(tw);
        Drawable hpDrawable = getResources().getDrawable(pic);
        hpDrawable.setBounds(0, 0, 100, 100);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        hpRB.setCompoundDrawables(null,hpDrawable,null,null);//

    }

    //6.listview的条目点击时会调用该方法   parent:代表listviw  view:点击的条目上的那个view对象   position:条目的位置  id： 条目的id
    //@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        //需要获取条目上bean对象中url做跳转
        CardBean bean = (CardBean) parent.getItemAtPosition(position);

        String url = bean.card_url;
        String name = bean.title;
        String des = bean.des;
        String apply_num = bean.clicknum.toString();
        String logo = bean.icon;
        //跳转浏览器
        Intent intent = new Intent(getActivity() , CardContentActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        intent.putExtra("name",name);
        intent.putExtra("url",url);
        intent.putExtra("des",des);
        intent.putExtra("apply_num",apply_num);
        intent.putExtra("logo",logo);
        startActivity(intent);

    }

}