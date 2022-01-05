package com.example.testdagger.module;

import android.app.Activity;

import com.example.testdagger.SecondActivity;
import com.example.testdagger.component.SecondActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = SecondActivityComponent.class)
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ClassKey(SecondActivity.class)
    public abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);

}
