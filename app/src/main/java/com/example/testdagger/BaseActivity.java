package com.example.testdagger;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dagger.android.AndroidInjection;

public abstract class BaseActivity extends AppCompatActivity {

    protected TextView txt1;

    public String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         *  需要调用 AndroidInjection.inject(this); 来真实的执行注入操作
         */
        if (needAutoInject()){
            AndroidInjection.inject(this);
        }else{
            manualInject();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt1.append(TAG+" \n ");
        initView();
    }

    protected abstract void initView();

    public abstract boolean needAutoInject();

    public void manualInject(){}


    public TextView append(TextView view,String content){
        view.append(content+"\n");
        return view;
    }
}