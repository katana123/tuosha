package com.example.tuosha;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.client.CustomApplication;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;

public class ContentWebActivity extends Activity  {
    private CustomApplication customApplication;
    public static WebView webView;
    private FragmentManager fManager = null;
    public ContentWebActivity() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        try{
            if(ContentWebActivity.webView==null){
                ContentWebActivity.webView=new WebView(this);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setContentView(R.layout.activity_web_content);

        customApplication = (CustomApplication)getApplication();
        customApplication.setContentWebActivity(this);


        Intent intent = getIntent();//获取传来的intent对象

        String title = intent.getStringExtra("name");
        String time = intent.getStringExtra("newstime");
        String apply_num = intent.getStringExtra("apply_num");
        String extInfo = intent.getStringExtra("extInfo");
        TextView txt_title = findViewById(R.id.txt_title);
        txt_title.setText(title);

        TextView pub_time = findViewById(R.id.pub_time);
        pub_time.setText(time);

        TextView read_count = findViewById(R.id.read_count);
        read_count.setText(apply_num);

        webView = findViewById(R.id.txt_content);
        webView.loadData(extInfo, "text/html; charset=UTF-8", null);


        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);


        ImageView backbtn = findViewById(R.id.reback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ContentWebActivity.this , MainActivity.class);
//               intent.putExtra("tag","ContentActivity");
//                onDestory();
//                startActivity(intent);
//                finish();
                //MainActivity.changeFragment(CardActivity.class.getName());
                onBackPressed();
            }
        });
    }
    public void onDestory(){
        removeActivity(this);
    }

    @Override
    public void onBackPressed() {

            super.onBackPressed();

    }
}
