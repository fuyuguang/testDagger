package com.example.testdagger.dependencies;

import com.example.testdagger.component.MyAppComponent;
import com.example.testdagger.scope.ActivityScope;

import dagger.Component;

/**
 * 1,使用时必须设置父Component，
 */
@Component(modules = FiveModule.class,dependencies = MyAppComponent.class)
@ActivityScope
public interface FiveComponent {

    void injectFive(DependenciesActivity activity);
}
