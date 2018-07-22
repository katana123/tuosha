package com.example.tuosha;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.Utils.ActivityCollector.removeActivity;

public class ApplyActivity extends Activity  {
    public ApplyActivity() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.activity_apply);
        WebView wv = findViewById(R.id.word_web_view);
        Intent intent = getIntent();//获取传来的intent对象
        String data = intent.getStringExtra("url");//获取键值对的键名
        wv.loadUrl(data);

        ImageView backbtn = findViewById(R.id.reback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplyActivity.this , CardContentActivity.class);
               intent.putExtra("tag","CardActivity");
                onDestory();
                startActivity(intent);
                finish();
                //MainActivity.changeFragment(CardActivity.class.getName());
            }
        });
    }
    public void onDestory(){
        removeActivity(this);
    }
}
