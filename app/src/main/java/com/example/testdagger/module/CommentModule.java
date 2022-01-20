package com.example.testdagger.module;

import com.example.testdagger.androidinjector.Usr;
import com.example.testdagger.bean.Dog;

import dagger.Module;
import dagger.Provides;

/**
 * 提供 Provides 的Module
 */
@Module
public class CommentModule {

    @Provides
    public Usr prodiverUrs() {
        return new Usr();
    }


    @Provides
    public Dog prodiverDog() {
        return new Dog();
    }

}
