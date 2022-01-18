package com.example.testdagger.subcomponent;

import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SubComponentActivity activity);
}
