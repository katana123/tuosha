package com.example.tuosha;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tuosha.cache.ImageLoader;
import com.example.tuosha.model.JqCatsEntity;
import com.example.tuosha.model.KouziBean;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.tuosha.Utils.ImageUtils.getDrawable;

public class JqCatsAdapter extends BaseAdapter {

    private ArrayList<JqCatsEntity> mJqCatsEntity;
    private Context context;
    private Handler handler = null;

    public JqCatsAdapter(Context context, ArrayList<JqCatsEntity> mJqCatsEntity) {
        this.mJqCatsEntity = mJqCatsEntity;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mJqCatsEntity.size();
    }

    @Override
    public Object getItem(int position) {
        return mJqCatsEntity.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView != null) {
            view = convertView;
        } else {
            //方法一：推荐
            //context:上下文, resource:要转换成view对象的layout的id, root:将layout用root(ViewGroup)包一层作为codify的返回值,一般传null
            view = View.inflate(context, R.layout.item_jqcats_layout, null);//将一个布局文件转换成一个view对象
        }

        final TextView jiqianCat = (TextView) view.findViewById(R.id.textView0);
        JqCatsEntity JqCats = mJqCatsEntity.get(position);
        jiqianCat.setText(JqCats.name);

        final String url = JqCats.getImage();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    handler.post(runnableUi);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Runnable runnableUi = new Runnable() {
                @Override
                public void run() {
                    Drawable drawable = getDrawable(url);
                    drawable.setBounds(0, 0, 100, 100);
                    jiqianCat.setCompoundDrawables(null, drawable, null, null);
                }

            };

        }).start();

        return view;
    }


}
