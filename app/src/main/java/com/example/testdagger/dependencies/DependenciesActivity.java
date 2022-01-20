package com.example.testdagger.dependencies;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdagger.MyApplication;
import com.example.testdagger.R;
import com.example.testdagger.bean.Dog;
//import com.example.testdagger.component.DaggerMyAppComponent;

import javax.inject.Inject;

public class DependenciesActivity extends AppCompatActivity {

    /**
     * 父 component 中 DogMudule 暴露的Dog，
     */
    @Inject
    public Dog mDog;


    /**
     *
     *  无法提供这个依赖，，因为父类中没有暴露提供 Usr的 方法。需要注释掉！！！
     *
     * 错误: [Dagger/MissingBinding] com.example.testdagger.androidinjector.Usr cannot be provided without
     * an @Inject constructor or an @Provides-annotated method.错误: [Dagger/MissingBinding]
     * com.example.testdagger.androidinjector.Usr cannot be provided without
     * an @Inject constructor or an @Provides-annotated method.
     * 只能继承父Component 中暴露（提供 Dog的  provideDog()）方法，供子Component使用，为暴露的方法不能在子Component中使用
     *
     *
     */
//    @Inject
//    Usr mUsr;

    @Inject
    FiveBean mFiveBean;
    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         * 子Component装载父Component调用的方法命名规则，调用方法名称为（父Component类名，首字母变小写）
         */
        DaggerFiveComponent.builder().myAppComponent(MyApplication.getMyAppComponent()).fiveModule(new FiveModule()).build().injectFive(this);

        /**
         * 子Component即便没有使用父Component 中暴露的方法，也需要调用 myAppComponent来设置父Component，不然报：
         * Caused by: java.lang.IllegalStateException: com.example.testdagger.component.MyAppComponent must be set
         */
        //DaggerFiveComponent.builder().fiveModule(new FiveModule()).build().injectFive(this);

        /**
         *  需要调用 AndroidInjection.inject(this); 来真实的执行注入操作
         */
        //AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt1.setText("ThreeActivity   "+" mFiveBean  : "+mFiveBean.toString());
        txt1.append("    "+" mDog  : "+mDog .toString());

    }
}