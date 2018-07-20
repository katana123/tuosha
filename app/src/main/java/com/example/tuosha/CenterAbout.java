package com.example.tuosha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CenterAbout extends Activity {
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.center_about);
        ImageView backbtn=(ImageView)findViewById(R.id.reback);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterAbout.this , MainActivity.class);
                intent.putExtra("tag","CenterActivity");
                startActivity(intent);
            }
        });
    }
}
