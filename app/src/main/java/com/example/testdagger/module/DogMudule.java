package com.example.testdagger.module;

import com.example.testdagger.bean.Dog;
import com.example.testdagger.bean.Usr;

import dagger.Module;
import dagger.Provides;

@Module
public class DogMudule {

    @Provides
    public Dog prodiverDog() {
        return new Dog();
    }

}
