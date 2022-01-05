package com.example.testdagger.component;

import com.example.testdagger.MainActivity;
import com.example.testdagger.module.MainActivityModule;

import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
