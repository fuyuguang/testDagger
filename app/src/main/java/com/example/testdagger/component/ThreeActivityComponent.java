package com.example.testdagger.component;

import com.example.testdagger.ThreeActivity;
import com.example.testdagger.module.ThreeActivityModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
@Subcomponent(modules = ThreeActivityModule.class)
public interface ThreeActivityComponent extends AndroidInjector<ThreeActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ThreeActivity>{}
}
