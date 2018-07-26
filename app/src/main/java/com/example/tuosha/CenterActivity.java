package com.example.tuosha;

import android.Manifest;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tuosha.Utils.ActivityCollector;
import com.example.tuosha.Utils.UserManage;
import com.example.tuosha.download.DownLoadUtils;
import com.example.tuosha.download.DownloadApk;

import static com.example.tuosha.client.CustomApplication.getMyApplication;


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
        String uname = UserManage.getInstance().getUserInfo(getMyApplication()).getNickname();
        TextView t_name = mView.findViewById(R.id.user_name);
        t_name.setText(uname);

          //关于我们
        TextView t_about = (TextView) mView.findViewById(R.id.c_about);
        t_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Toast.makeText(getActivity(),"你的提示内容",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity() , CenterAbout.class);
                startActivity(intent);
            }
        });
        /*下载更新*/
        //1.注册下载广播接收器
        DownloadApk.registerBroadcast(getActivity());
        //2.删除已存在的Apk
        DownloadApk.removeFile(getActivity());
        TextView t_update = (TextView) mView.findViewById(R.id.c_update);
        t_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "没有新版本更新，当前已是最新版本", Toast.LENGTH_SHORT).show();
                //3.如果手机已经启动下载程序，执行downloadApk。否则跳转到设置界面
                if (DownLoadUtils.getInstance(getActivity()).canDownload()) {
                    DownloadApk.downloadApk(getActivity(), "http://192.168.100.245:9000/download/apk/tuosha.apk", "tuosha更新", "tuosha");
                } else {
                    DownLoadUtils.getInstance(getActivity()).skipToDownloadManager();
                }
            }
        });


        TextView t_exit = (TextView) mView.findViewById(R.id.c_exit);
        t_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                new AlertDialog.Builder(getActivity()).setTitle("确认退出吗？")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 点击“确认”后的操作
                                UserManage.getInstance().saveUserInfo(getMyApplication(), "", "","","");
                                android.os.Process.killProcess(android.os.Process.myPid());
                                AppExit(getActivity());
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("返回", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 点击“返回”后的操作,这里不设置没有任何操作
                            }
                        }).show();


        }
        });
        return mView;
    }
    public void AppExit(Context context) {
        try {
            ActivityCollector.finishAll();
            ActivityManager activityMgr = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            //杀进程需要android的permission
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.KILL_BACKGROUND_PROCESSES) != PackageManager.PERMISSION_GRANTED) {

                activityMgr.killBackgroundProcesses(context.getPackageName());
            }
            System.exit(0);
        } catch (Exception ignored) {}
    }
}
