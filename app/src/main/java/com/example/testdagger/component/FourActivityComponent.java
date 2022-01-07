package com.example.testdagger.component;

import com.example.testdagger.FourActivity;
import com.example.testdagger.ThreeActivity;
import com.example.testdagger.module.FourActivityModule;
import com.example.testdagger.module.ThreeActivityModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = FourActivityModule.class)
public interface FourActivityComponent extends AndroidInjector<FourActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<FourActivity>{}
}
