package com.example.testdagger;

import android.app.Application;


import com.example.testdagger.component.DaggerMyAppComponent;

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

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyAppComponent.builder().build().inject(this);
    }


    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }
}
