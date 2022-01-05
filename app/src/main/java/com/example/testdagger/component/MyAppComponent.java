package com.example.testdagger.component;

import com.example.testdagger.MyApplication;
import com.example.testdagger.module.BuildersModule;
import com.example.testdagger.module.MainActivityModule;
import com.example.testdagger.module.SecondActivityModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
//        MainActivityModule.class,
//        SecondActivityModule.class,
        BuildersModule.class,
        AndroidSupportInjectionModule.class
})
public interface MyAppComponent extends AndroidInjector<MyApplication>{

//    MyApplication inject(MyApplication application);
//
    @Component.Builder
    abstract  class Builder extends AndroidInjector.Builder<MyApplication>{}
}

