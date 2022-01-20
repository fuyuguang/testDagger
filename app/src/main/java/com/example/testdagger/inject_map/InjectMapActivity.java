package com.example.testdagger.inject_map;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.R;
import com.example.testdagger.androidinjector.Person;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;

/**
 * 参考博客：
 * https://www.jianshu.com/p/c1411ff6c975
 */
public class InjectMapActivity extends AppCompatActivity {

    @Named("1")
    @Inject
    Map<String,Person> mMap1;

    @Inject
    @Named("2")
    Map<Integer,Person> mMap2;

    @Inject
    Map<Long,Person> mMap3;

    /**
     *  Map<Class,Person> mMap4, 这样写会报错
     *  java.util.Map<java.lang.Class,com.example.testdagger.androidinjector.Person> cannot be provided without an @Provides-annotated method.
     *
     *  必须要带泛型
     */
    @Inject
    Map<Class<?>,Person> mMap4;
    //Map<Class,Person> mMap4;

    /**
     * 用Map<Class<Number>,Person> mMap5; 定义会报错，
     * Dagger类型严格，key中定义的是  Class<? extends Number> value(); 也只能用 Class<? extends Number> 接收key
     */
    @QualifierType("Complexity")
    @Inject
    Map<Class<? extends Number>,Person> mMap5;
    //Map<Class<Number>,Person> mMap5;



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
        txt1.append("\n");
        txt1.setText("mMap 1 Map<Integer,Person> : \n \t\t" + mMap1.toString());
        txt1.append("\n");
        txt1.append(" mMap2Map<String,Person> : \n\t\t" + mMap2.toString());
        txt1.append("\n");

        txt1.append("mMap3  Map<Long,Person> : \n\t\t" + mMap3.toString());
        txt1.append("\n");
        txt1.append("Map<Class<?>,Person> mMap4 : \n\t\t" + mMap4.toString());
        txt1.append("\n");
        txt1.append("mMap5 Map<Class,Person> : \n\t\t" + mMap5.toString());

    }
}