package com.example.testdagger;

import android.app.Application;

import com.example.testdagger.component.DaggerMyAppComponent;
import com.example.testdagger.component.MyAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
//import dagger.android.support.DaggerApplication;

/**
 * 1，该类需要 implements HasAndroidInjector 接口，
 * 2，定义成员变量@Inject DispatchingAndroidInjector<Object> dispatchingAndroidInjector;
 * DispatchingAndroidInjector类的构造方法上已经加了 @Inject，切构造方法的参数已经在DaggerMyAppComponent类中生成
 * 调用 DispatchingAndroidInjector_Factory.newInstance 即可创建
 * 3， 调用 DaggerMyAppComponent.builder().build().inject(this);
 */
public class MyApplication extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;
    private static MyAppComponent mMyAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //DaggerMyAppComponent.builder().build().inject(this);

        /**
         * 测试Component.Builder中的  BuildModule用 ，
         */
        //DaggerMyAppComponent.builder().buildModule(new BuildModule(this)).build().inject(this);


        //DaggerMyAppComponent.builder().buildModule(new BuildModule(this)).build().inject(this);
        //测试@BindsInstance，用法，代替

        mMyAppComponent = DaggerMyAppComponent.builder().application(this).build();
        mMyAppComponent.inject(this);
    }

    public static MyAppComponent getMyAppComponent(){
        return mMyAppComponent;
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
