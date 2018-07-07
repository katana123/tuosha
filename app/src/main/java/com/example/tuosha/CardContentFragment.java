package com.example.tuosha;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
class CardContentFragment extends Fragment{
    CardContentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_content, container, false);
        TextView s_title = (TextView) view.findViewById(R.id.s_title);
        //getArgument获取传递过来的Bundle对象
        s_title.setText("大额贷款xfgdfhdshfgd");

        //TextView read_count = (TextView) view.findViewById(R.id.read_count);
       // read_count.setText("121545");

        //TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
       // txt_content.setText("121545");
        //txt_content.setTextColor(Color.parseColor("#000000"));
        return view;
    }
}
