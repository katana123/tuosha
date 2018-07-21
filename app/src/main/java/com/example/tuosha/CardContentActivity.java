package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class CardContentActivity extends AppCompatActivity {
    private TextView txt_title;

    private Context mContext;
    private ArrayList<CardBean> datas = null;


    private TextView backbtn;
    private  String bar_title;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_content);
        mContext = CardContentActivity.this;

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        final String url = intent.getStringExtra("url");
        String logo = intent.getStringExtra("logo");
        String des = intent.getStringExtra("des");
        String applynum = intent.getStringExtra("apply_num");

        TextView s_title = (TextView) findViewById(R.id.s_title);
        s_title.setText(name);
        TextView apply_num = (TextView) findViewById(R.id.apply_num);
        apply_num.setText("已申请"+applynum+"人");
        TextView s_des = (TextView) findViewById(R.id.s_des);
        s_des.setText(des);
        ImageView item_img_icon = (ImageView) findViewById(R.id.item_img_icon);
        if (logo==""){
            item_img_icon.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.quick_option_text_over));//设置imageView的图片
        }else{
            if(!fileIsExists(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+logo))
            {
                item_img_icon.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.quick_option_text_over));
            }else {
                item_img_icon.setImageURI(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + logo)));
            }
        }


        backbtn = (TextView) findViewById(R.id.s_button);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext , ApplyActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
               // intent.setData(Uri.parse(url));

                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        ImageView backbtn=(ImageView)findViewById(R.id.reback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardContentActivity.this , MainActivity.class);
                intent.putExtra("tag","CardActivity");
                startActivity(intent);

            }
        });
    }



    @Override
    public void onBackPressed() {

    }

    public boolean fileIsExists(String strFile)
    {
        try
        {
            File f=new File(strFile);
            if(!f.exists())
            {
                return false;
            }

        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
}
