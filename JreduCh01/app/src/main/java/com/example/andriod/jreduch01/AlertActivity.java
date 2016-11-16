package com.example.andriod.jreduch01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener {
private Button single,more,alert,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        single= (Button) findViewById(R.id.bt1);
        single.setOnClickListener(this);
        more= (Button) findViewById(R.id.bt2);
        more.setOnClickListener(new more());
        alert= (Button) findViewById(R.id.bt3);
        other= (Button) findViewById(R.id.bt4);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getLayoutInflater().inflate(R.layout.toast_layout,null);
                ImageView iv= (ImageView) view.findViewById(R.id.pop);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getBaseContext(),"点击了图片",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog.Builder bulider=new AlertDialog.Builder(AlertActivity.this);
                bulider.setView(view);
                AlertDialog alertdialog=bulider.create();
                alertdialog.show();
            }
        });
        //对话框生成
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
                builder.setTitle("提示");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("确定吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"您点击了确定按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(),"您点击了取消按钮",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);   //点击除了确定取消的按钮外，没有反应
                AlertDialog alertDialog=builder.create();  //提示框生成，必须
                alertDialog.show();  //显示 提示框，必须
            }
        });


    }
    //单选框生成
    @Override
    public void onClick(View v) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
        builder.setTitle("请选择");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(true);
        final String [] items={"北京","上海","烟台"};
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           Toast.makeText(getBaseContext(),items[which].toString(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();  //点击对话框消失
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    public class more implements View.OnClickListener{
        @Override
        public void onClick(View v) {
          AlertDialog.Builder builder=new AlertDialog.Builder(AlertActivity.this);
            builder.setTitle("请选择");
            builder.setIcon(R.mipmap.ic_launcher);
            final String items[]={"上海","北京","烟台","南京"};
            boolean [] choice={true,true,false,false};
            final boolean [] itemChice=new boolean[items.length];
            itemChice[0]=true;
            itemChice[1]=false;
            builder.setMultiChoiceItems(items, choice, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(getBaseContext(), items[which].toString(), Toast.LENGTH_SHORT).show();
                        itemChice[which] = true;
                    }else{
                        itemChice[which]=false;
                    }
                }
            });
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String str="";
                    for(int ch=0;ch<items.length;ch++){
                        str+=(itemChice[ch]==true)?items[ch]:"";
                    }
                    Toast.makeText(getBaseContext(),str,Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }

            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }

    }

}
