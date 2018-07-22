package com.example.tuosha;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class CenterActivity extends Fragment{
    //1.生成两个imageview对象，和那两张图片对应
    private ImageView blurImageView;
    private ImageView avatarImageView;
    //2.生成view对象
    private View mView;
    //3.context
    private Context mContext;

    public CenterActivity() {

    }

    public static CenterActivity newInstance() {
        CenterActivity fragment = new CenterActivity();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.activity_center, null);

        TextView textView = mView.findViewById(R.id.c_about);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Toast.makeText(getActivity(),"你的提示内容",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , CenterAbout.class);
                startActivity(intent);
            }
        });

        return mView;
    }

}
