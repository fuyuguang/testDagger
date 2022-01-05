package com.example.testdagger.module;


import com.example.testdagger.bean.Usr;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    @Provides
    public Usr provideUsr(){
        return new Usr();
    }
}
