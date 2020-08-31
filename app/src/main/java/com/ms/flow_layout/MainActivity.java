package com.ms.flow_layout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.view.flowlayout.FlowLayout;

public class MainActivity extends AppCompatActivity {

    private FlowLayout flowLayout;


    private String[] datas = new String[]{
            "登录", "登录页面", "注册", "注册页面", "注册页面逻辑",
            "主页", "扫码", "二维码添加好友", "啦啦啦", "😝",

    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowLayout = findViewById(R.id.flowLayout);


        for (int i = 0; i < datas.length; i++) {

            TextView textView = new TextView(this);
            textView.setText(datas[i]);
            textView.setBackground(getDrawable(R.drawable.tag_background));
            textView.setTextColor(Color.parseColor("#333333"));
            textView.setTextSize(DisplayUtils.sp2px(12,1));

            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(MainActivity.this, datas[finalI]+"", Toast.LENGTH_SHORT).show();

                }
            });

            textView.setPadding(30, 10, 30, 10);
            FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(12, 12, 12, 12);
            flowLayout.addView(textView, params);
        }
    }
}