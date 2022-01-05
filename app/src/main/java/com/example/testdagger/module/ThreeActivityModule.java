package com.example.testdagger.module;

import com.example.testdagger.bean.Usr;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreeActivityModule {

    @Provides
    public Usr ProvideUsr(){
        return new Usr();
    }
}
