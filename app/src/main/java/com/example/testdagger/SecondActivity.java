package com.example.testdagger;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.bean.Usr;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class SecondActivity extends AppCompatActivity {

    @Inject
    Usr mUser;
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
        txt1.setText("SecondActivity   "+mUser.name);
    }
}