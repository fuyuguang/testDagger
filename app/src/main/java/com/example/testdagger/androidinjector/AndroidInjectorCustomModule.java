package com.example.testdagger.androidinjector;


import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * module 引用了  SecondActivityComponent  (subcomponents = SecondActivityComponent.class)
 */
@Module(subcomponents = AndroidInjectorActivityComponent.class)
public abstract class AndroidInjectorCustomModule {
    @Binds
    @IntoMap
    @ClassKey(AndroidInjectorActivity.class)
    abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(AndroidInjectorActivityComponent.Factory factory);

}