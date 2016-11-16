package com.example.andriod.jreduch01;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);
        Button pop= (Button) findViewById(R.id.pop);
        View v=getLayoutInflater().inflate(R.layout.toast_layout,null);
        //得到pop的样式
        final PopupWindow pw=new PopupWindow(v);
        pw.setFocusable(true);//设置焦点可用
        ColorDrawable cd=new ColorDrawable();//设置背景色
        pw.setBackgroundDrawable(cd);
        pw.setAnimationStyle(R.style.pop);//设置动画效果
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pw.setWidth(v.getWidth());//设置高度
                int height=getResources().getDisplayMetrics().heightPixels/3;
                pw.setHeight(height);//设置长度
                pw.showAsDropDown(v,200,100);//显示位置
            }
        });
    }
}
