package com.example.testdagger;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.bean.Dog;
import com.example.testdagger.bean.Usr;
import com.example.testdagger.module.BuildersModule;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * 测试 @ContributesAndroidInjector用法
 *
 * {@link BuildersModule#inject2()}
 */
public class ThreeActivity extends AppCompatActivity {

    @Inject
    Usr mUser;
    @Inject
    Dog mDog;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         *  需要调用 AndroidInjection.inject(this); 来真实的执行注入操作
         */
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt1.setText("ThreeActivity   "+mUser.name +  " mDog  : "+mDog.name);
    }
}