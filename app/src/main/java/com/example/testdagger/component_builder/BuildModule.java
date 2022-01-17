package com.example.testdagger.component_builder;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;

@Module
public class BuildModule {

    private  Application mApplication;

    /**
     * 测试 @BindsInstance时，这个类要变成无参的构造函数才可以
     * @param application
     */
    public BuildModule(Application  application){
        mApplication = application;
    }

    @Provides
    public Utils provideUtils(){
        return new Utils(mApplication);
    }
}
