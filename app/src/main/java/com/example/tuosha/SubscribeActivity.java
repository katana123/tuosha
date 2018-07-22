package com.example.tuosha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tuosha.Utils.ActivityCollector.addActivity;

public class SubscribeActivity extends AppCompatActivity {

    private Button subscrube;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addActivity(this);
        setContentView(R.layout.subscribe_main);

        TextView tv = findViewById(R.id.sub_title);
        TextPaint tp = tv.getPaint();
        tp.setFakeBoldText(true);

        subscrube = findViewById(R.id.subscribe_button);
        subscrube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SubscribeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
