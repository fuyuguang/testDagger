package com.example.testdagger.module;


import com.example.testdagger.SecondActivity;
import com.example.testdagger.bean.Usr;
import com.example.testdagger.component.SecondActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

//@Module
//public class SecondActivityModule {
//
//    @Provides
//    public Usr provideUsr(){
//        return new Usr();
//    }
//}

/**
 * module 引用了  SecondActivityComponent  (subcomponents = SecondActivityComponent.class)
 */
@Module(subcomponents = SecondActivityComponent.class)
public abstract class SecondActivityModule {
    @Binds
    @IntoMap
    @ClassKey(SecondActivity.class)
    abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Factory factory);

}