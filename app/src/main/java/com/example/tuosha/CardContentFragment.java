package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

@SuppressLint("ValidFragment")
class CardContentFragment extends Fragment {
    private FragmentManager fManager;
    private String txt_title;
    private ArrayList<BankBean> datas;



    @SuppressLint("ValidFragment")
    public CardContentFragment(FragmentManager fManager, String txt_title) {
        this.fManager = fManager;
        this.txt_title = txt_title;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_card_content, container, false);
        TextView txt_title = (TextView) getActivity().findViewById(R.id.bank_title);
        txt_title.setText("提额通道");

        String name = getArguments().getString("name");
       // String url = getArguments().getString("url");
        String logo = getArguments().getString("logo");
        String des = getArguments().getString("des");
        String applynum = getArguments().getString("apply_num");

        TextView s_title = (TextView) view.findViewById(R.id.s_title);
        s_title.setText(name);
        TextView apply_num = (TextView) view.findViewById(R.id.apply_num);
        apply_num.setText("已申请"+applynum+"人");
        TextView s_des = (TextView) view.findViewById(R.id.s_des);
        s_des.setText(des);
        ImageView item_img_icon = (ImageView) view.findViewById(R.id.item_img_icon);
        if (logo==""){
            item_img_icon.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.quick_option_text_over));//设置imageView的图片
        }else{
            if(!fileIsExists(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+logo))
            {
                item_img_icon.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.quick_option_text_over));
            }else {
                item_img_icon.setImageURI(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + logo)));
            }
        }

        //设置图标点击事件
        TextView tv0 = (TextView) view.findViewById(R.id.s_button);
        tv0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                String name = getArguments().getString("name");
                String url = getArguments().getString("url");
                fManager = getFragmentManager();
                FragmentTransaction fTransaction = fManager.beginTransaction();
                BankWebFragment ncFragment = new BankWebFragment();
                Bundle bd = new Bundle();
                // bd.putString("content", datas.get(position).getDes());
                bd.putString("name", name);
                bd.putString("url", url);
                ncFragment.setArguments(bd);

                fTransaction.replace(R.id.fl_bank, ncFragment);
                //调用addToBackStack将Fragment添加到栈中
                fTransaction.addToBackStack(null);
                fTransaction.commit();

            }
        });

        return view;
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
