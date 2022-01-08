package com.example.testdagger.module;

import com.example.testdagger.bean.Usr;

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
}
