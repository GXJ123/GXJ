package com.example.andriod.jreduch01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Onclick extends AppCompatActivity implements View.OnClickListener {
   private Button login,regit,reset,finish;
    private EditText user,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick);
        user= (EditText) findViewById(R.id.user);
        pwd= (EditText) findViewById(R.id.pwd);
        //匿名监听最简单的方法
        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        // 布局监听，在布局内定义Onclick="方法名",参数必须View
        regit= (Button) findViewById(R.id.regit);

        // 本类监听，实现onClick方法
        reset= (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

        //内部类监听，自己定义函数实现View.OnclickListener()方法
        finish= (Button) findViewById(R.id.finish);
        finish.setOnClickListener(new exit());
        //匿名监听
    }

    @Override
    public void onClick(View v) {
        user.setText("12");
        pwd.setText("34");
    }

    public class exit implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            finish();
        }
    }

    public  void regit(View view){
        Toast.makeText(getBaseContext(),"你点击了注册按钮",Toast.LENGTH_SHORT).show();
    }
}
