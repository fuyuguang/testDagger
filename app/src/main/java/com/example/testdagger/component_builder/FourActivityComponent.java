package com.example.testdagger.component_builder;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface FourActivityComponent extends AndroidInjector<FourActivity> {

    @Subcomponent.Factory
    public interface Factory extends AndroidInjector.Factory<FourActivity>{}
}
