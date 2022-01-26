package com.example.testdagger.lazy_provider;

import android.util.Log;

import javax.inject.Inject;

public class BananaBean {

    @Inject
    public BananaBean() {
        Log.d("test", "BananaBean()");
    }
}