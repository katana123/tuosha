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
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.Utils.UserManage;
import com.example.tuosha.client.CustomApplication;

import java.io.File;
import java.util.ArrayList;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;
import static com.example.tuosha.client.CustomApplication.getMyApplication;

public class CardContentActivity extends AppCompatActivity {
    private TextView txt_title;

    private Context mContext;
    private ArrayList<CardBean> datas = null;
    public static WebView webView;

    private ImageView backbtn;
    private  TextView barbutton;
    private CustomApplication customApplication;
    private FragmentManager fManager = null;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);

        try{
            if(ApplyActivity.webView==null){
                ApplyActivity.webView=new WebView(this);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setContentView(R.layout.activity_card_content);

        customApplication = (CustomApplication) getApplication();
        if (customApplication.getCardContentActivity()==null){
            customApplication.setCardContentActivity(this);
        }

        mContext = CardContentActivity.this;

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String url = intent.getStringExtra("url");
        String logo = intent.getStringExtra("logo");
        String des = intent.getStringExtra("des");
        String applynum = intent.getStringExtra("apply_num");
        if (name!=null) {
            UserManage.getInstance().saveBankCardInfo(customApplication.getCardContentActivity(), name, url, logo, des, applynum);
        }else{
            if (UserManage.getInstance().hasBankCardInfo(customApplication.getCardContentActivity())) {
                name = UserManage.getInstance().getBankCardInfo(getMyApplication()).getName();
                url = UserManage.getInstance().getBankCardInfo(getMyApplication()).getLink();
                logo = UserManage.getInstance().getBankCardInfo(getMyApplication()).getImage();
                des = UserManage.getInstance().getBankCardInfo(getMyApplication()).getAdvantage();
                applynum = String.valueOf(UserManage.getInstance().getBankCardInfo(getMyApplication()).getViews());
            }
        }
        final String link=url;
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


        barbutton = (TextView) findViewById(R.id.s_button);
        barbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext , ApplyActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
               // intent.setData(Uri.parse(url));

                intent.putExtra("url",link);
                startActivity(intent);
                finish();
            }
        });

//        ImageView backbtn=(ImageView)findViewById(R.id.reback);
//        backbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CardContentActivity.this , MainActivity.class);
//                intent.putExtra("tag","CardActivity");
//                startActivity(intent);
//                finish();
//            }
//        });
        fManager = getFragmentManager();
        backbtn = findViewById(R.id.reback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fManager.getBackStackEntryCount() == 0) {
                    finish();
                } else {
                    fManager.popBackStack();
                   // txt_title.setText("提额通道");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (fManager.getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            fManager.popBackStack();
            //txt_title.setText("");
        }
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
