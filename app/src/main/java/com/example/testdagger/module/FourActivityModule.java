package com.example.testdagger.module;

import android.widget.Toast;

import com.example.testdagger.MyApplication;
import com.example.testdagger.bean.Usr;

import dagger.Module;
import dagger.Provides;

@Module
public class FourActivityModule {

    @Provides
    public Usr provideUsr() {
        System.out.println("FourActivityModule");
        return new Usr();
    }
}
