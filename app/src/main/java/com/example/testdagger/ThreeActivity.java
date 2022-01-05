package com.example.testdagger;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.bean.Usr;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 *  SecondActivity 和 ThreeActivity 都改用到BuildersModule,需要在BuildersModule类@Module注解中加入两个
 *  @Module(subcomponents = {SecondActivityComponent.class,ThreeActivityComponent.class}) subComponent
 */
public class ThreeActivity extends AppCompatActivity {

    @Inject
    Usr mUser;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt1.setText("ThreeActivity   "+mUser.name);
    }
}