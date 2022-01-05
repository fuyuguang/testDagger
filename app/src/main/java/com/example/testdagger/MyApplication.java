package com.example.testdagger;

import com.example.testdagger.component.DaggerMyAppComponent;

import dagger.android.AndroidInjector;


import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;


public class MyApplication extends DaggerApplication {

    DispatchingAndroidInjector  mDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
//        DaggerMyAppComponent.builder()
////                .secondActivityModule(new SecondActivityModule())
//                .build().inject(this);
    }


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerMyAppComponent.builder().create(this);
    }
}
