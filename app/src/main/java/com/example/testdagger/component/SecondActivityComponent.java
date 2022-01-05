package com.example.testdagger.component;

import android.app.Activity;

import com.example.testdagger.SecondActivity;
import com.example.testdagger.module.SecondActivityModule;

import dagger.Binds;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;


//@Component(modules = SecondActivityModule.class)
//public interface SecondActivityComponent {
//    void inject(SecondActivity secondActivity);
//}

@Subcomponent(modules = SecondActivityModule.class)
public interface SecondActivityComponent extends AndroidInjector<SecondActivity> {

    @Subcomponent.Builder
    abstract  class Builder extends AndroidInjector.Builder<SecondActivity>{}

}