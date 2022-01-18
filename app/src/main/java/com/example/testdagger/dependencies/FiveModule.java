package com.example.testdagger.dependencies;

import dagger.Module;
import dagger.Provides;

@Module
public class FiveModule {

    @Provides
    public FiveBean getFiveBean(){
        return new FiveBean();
    }
}
