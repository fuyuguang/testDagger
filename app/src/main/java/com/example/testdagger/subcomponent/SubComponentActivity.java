package com.example.testdagger.subcomponent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.MyApplication;
import com.example.testdagger.R;
import com.example.testdagger.bean.Dog;
import com.example.testdagger.bean.Usr;

import com.example.testdagger.dependencies.FiveBean;
import com.example.testdagger.dependencies.FiveModule;

import javax.inject.Inject;

public class SubComponentActivity extends AppCompatActivity {

    /**
     * 注入的字段要用public修饰， Dog是父component中的不需要像 depandance 一样，在父类中暴露 Dog 方法
     */
    @Inject
    public Dog mDog;
    @Inject
    public Activity mActivity;

    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * 1，先得到父Component,在装载子Component，
         * 2，如何装载子Component在父Component中定义
         */
        MyApplication.getMyAppComponent().addActivityComponent(new ActivityModule()).inject(this);

        /**
         *  需要调用 AndroidInjection.inject(this); 来真实的执行注入操作
         */
        //AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt1.setText("SubComponentActivity   "+" mDog  : "+mDog.toString());
        txt1.append("    "+" mActivity  : "+mActivity .toString());

    }
}