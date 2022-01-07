package com.example.testdagger.component;

import android.app.Application;

import com.example.testdagger.MyApplication;
import com.example.testdagger.module.BuildersModule;
import com.example.testdagger.module.MainActivityModule;
import com.example.testdagger.module.SecondActivityModule;

import dagger.BindsInstance;
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

//    /**
//     * 两种的区别：https://www.jianshu.com/p/9181757ccb39
//     * 方式1：
//     */
//    @Component.Builder
//    abstract  class Builder extends AndroidInjector.Builder<MyApplication>{}


//    /**
//     * 方式2：
//     */
//    @Component.Factory
//    abstract  class Factory implements AndroidInjector.Factory<MyApplication> {}


}





