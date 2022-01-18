package com.example.testdagger.subcomponent;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    public Activity getActivity(){
        return new Activity();
    }
}
