package com.example.testdagger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testdagger.bean.Usr;
import com.example.testdagger.component.DaggerMainActivityComponent;
import com.example.testdagger.module.MainActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Usr mUser;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainActivityComponent.builder()
                .mainActivityModule(new MainActivityModule())
                .build()
                .inject(this);

        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt1.setText(mUser.name);
        txt1.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}