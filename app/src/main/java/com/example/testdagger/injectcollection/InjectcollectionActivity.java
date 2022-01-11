package com.example.testdagger.injectcollection;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.R;
import com.example.testdagger.bean.Dog;
import com.example.testdagger.bean.Usr;

import java.util.Arrays;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

public class InjectcollectionActivity extends AppCompatActivity {


//    @Named("1")
    @Inject
    Set<Person> set;

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

        txt1.setText("InjectcollectionActivity   : " + set.toString());
    }
}