package com.example.testdagger.lazy_provider;

import android.util.Log;

import com.example.testdagger.scope.ApplicationScope;

import javax.inject.Inject;

/**
 * bean 对象上添加这个代表，单例的
 */
@ApplicationScope
public class GlobalBean {

    @Inject
    public GlobalBean() {
        Log.d("test", "GlobalBean()");
    }
}