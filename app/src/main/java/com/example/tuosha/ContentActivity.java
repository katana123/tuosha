package com.example.tuosha;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
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

//import com.example.R;

import com.alibaba.fastjson.JSONArray;
import com.example.tuosha.Utils.Protocols;
import com.example.tuosha.client.CustomApplication;
import com.example.tuosha.client.IMCGClientHandler;
import com.example.tuosha.model.ContentBean;
import com.example.tuosha.model.PostsEntity;
import com.example.tuosha.model.SWbean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.tuosha.client.CustomApplication.getInstance;


public class ContentActivity extends Fragment implements AdapterView.OnItemClickListener {

    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.xx1,
            R.drawable.xx2,
            R.drawable.xx3
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "轮播1",
            "轮播2",
            "轮播3"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private Context mContext;
    private CustomApplication customApplication;
    private ArrayList<ContentBean> allNews = new ArrayList<>();
    private ListView lv_news;

    public ContentActivity() {

    }

    public static ContentActivity newInstance() {
        ContentActivity fragment = new ContentActivity();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        mView=inflater.inflate(R.layout.activity_content, null);
        setView();
        initbtn(R.id.textView0,R.drawable.quick_option_album_nor);
        initbtn(R.id.textView1,R.drawable.quick_option_note_nor);
        initbtn(R.id.textView2,R.drawable.quick_option_photo_nor);
        initbtn(R.id.textView3,R.drawable.quick_option_scan_nor);
        initbtn(R.id.textView4,R.drawable.quick_option_album_nor);
        initbtn(R.id.textView5,R.drawable.quick_option_note_nor);
        initbtn(R.id.textView6,R.drawable.quick_option_photo_nor);
        initbtn(R.id.textView7,R.drawable.quick_option_scan_nor);

        TextView tv2 = mView.findViewById(R.id.textView0);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 1);
                bd.putString("erTitle", "如何入会");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });

        TextView tv3 = mView.findViewById(R.id.textView1);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 2);
                bd.putString("erTitle", "视频技术");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });
        TextView tv4 = mView.findViewById(R.id.textView2);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 3);
                bd.putString("erTitle", "新手专区");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });
        TextView tv5 = mView.findViewById(R.id.textView3);
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 4);
                bd.putString("erTitle", "达人交流圈");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });
        TextView tv6 = mView.findViewById(R.id.textView4);
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 5);
                bd.putString("erTitle", "历史黑科技");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });
        TextView tv7 = mView.findViewById(R.id.textView5);
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 6);
                bd.putString("erTitle", "经验神坛");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });
        TextView tv8 = mView.findViewById(R.id.textView6);
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 7);
                bd.putString("erTitle", "金融工具");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });
        TextView tv9 = mView.findViewById(R.id.textView7);
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SecondActivity.class);
                Bundle bd = new Bundle();
                bd.putInt("jisuId", 8);
                bd.putString("erTitle", "额度查询");
                intent.putExtras(bd);
                startActivity(intent);
            }
        });

        TextView tv = mView.findViewById(R.id.textView);
        tv.setSelected(true);

        lv_news = mView.findViewById(R.id.lv_news);

        lv_news.setOnItemClickListener(this);

        sendmessage();
        receivemsg();

        return mView;
    }


    private void setView(){
        mViewPaper = mView.findViewById(R.id.contentpic);

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
            mHandler.sendEmptyMessage(0);
        }
    }

    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            mViewPaper.setCurrentItem(currentItem);
            switch (msg.what) {
                case 200:
                    ArrayList<PostsEntity> postsEntities = new ArrayList<PostsEntity>();
                    CustomApplication application = (CustomApplication) getInstance();
                    if (application.getPostsEntities() != null) {
                        mContext = getActivity();
                        ArrayList<PostsEntity> allNews = ContentUtils.getAllNews(mContext, application.getPostsEntities());

                        //3.创建一个adapter设置给listview
                        ContentAdapter contentAdapter = new ContentAdapter(getActivity(), allNews);
                        lv_news.setAdapter(contentAdapter);

                        application.setContentList(null);
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

    private void sendmessage() {
        System.out.println("发送数据请求");
        Thread thread = new Thread() {
            public void run() {
                try {
                    IMCGClientHandler nettyClientHandler = new IMCGClientHandler(customApplication);
                    nettyClientHandler.start();
                    SWbean sWbean = new SWbean();
                    sWbean.setCommand(Protocols.CONTENTLIST);
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
                    CustomApplication customApplication = (CustomApplication) getInstance();

                    Thread.sleep(5000);
//                    System.out.println("customApplication的内容 :" + customApplication.getPostsEntities());

                    int i = 0;
                    while (customApplication.getPostsEntities() == null) {

                        i = i + 1;
                        System.out.println("du" + customApplication.getPostsEntities());
                        Thread.sleep(1000);
                        if (i > 50) break;
                    }

                    if (i < 50) {
                        Message message = new Message();
                        message.what = 200; //200代码获取数据正常
                        mHandler.sendMessage(message);

                    } else {
                        Message message = new Message();
                        message.what = -1; //代码获取数据 常
                        mHandler.sendMessage(message);

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

    //listview的条目点击时会调用该方法   parent:代表listviw  view:点击的条目上的那个view对象   position:条目的位置  id： 条目的id
    //@Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        //需要获取条目上bean对象中url做跳转
        PostsEntity bean = (PostsEntity) parent.getItemAtPosition(position);

//        String url = bean.news_url;

        //跳转浏览器
        Intent intent = new Intent();
        intent.setClass(mContext, SecondActivity.class);
        Bundle bd = new Bundle();
        bd.putString("name", bean.getName());
        bd.putString("apply_num", String.valueOf(bean.getViews()));
        bd.putString("newstime", String.valueOf(bean.getCreatedAt()));
        bd.putString("logo", bean.getImage());
        bd.putInt("id", bean.getId());
        bd.putString("extInfo", bean.getIntro());
        bd.putInt("type", 3);
        intent.putExtras(bd);
        startActivity(intent);
    }

}