package com.example.testdagger.inject_set;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.R;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

public class InjectSetActivity extends AppCompatActivity {


//    @Named("1")
    @Inject
    Set<Person> set;

//    不行 @Named("1") 没有 @IntoSet
//    @Named("1")
//    @Inject
//    Set<Person> mSet;

    @Named("2")
    @Inject
    Set<Person> mSet;

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

        txt1.setText("InjectcollectionActivity   set : " + set.toString());
        txt1.append("\n");
        txt1.append("\n");
        txt1.append("InjectcollectionActivity   mSet : " + mSet.toString());

    }
}