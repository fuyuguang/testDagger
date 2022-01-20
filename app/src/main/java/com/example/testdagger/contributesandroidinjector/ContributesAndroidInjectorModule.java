package com.example.testdagger.contributesandroidinjector;

import dagger.Module;
import dagger.Provides;


@Module
public class ContributesAndroidInjectorModule {

    @Provides
    public ContributesAndroidInjectorBean provideContributesAndroidInjectorBean() {
        return new ContributesAndroidInjectorBean();
    }
}
