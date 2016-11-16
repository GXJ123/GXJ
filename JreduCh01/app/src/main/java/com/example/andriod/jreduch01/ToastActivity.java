package com.example.andriod.jreduch01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {
private Button toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        toast= (Button) findViewById(R.id.toast);
    }
    public void Toast(View view){
        View v=getLayoutInflater().inflate(R.layout.toast_layout,null);
        ImageView iv= (ImageView) v.findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"您点击了图片",Toast.LENGTH_SHORT).show();
            }
        });
        //图片实现的位置，内容，时间长短
        Toast toast=Toast.makeText(ToastActivity.this,"自定义Toast",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(v);
        toast.show();
    }
}
