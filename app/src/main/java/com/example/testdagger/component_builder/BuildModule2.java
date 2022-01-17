package com.example.testdagger.component_builder;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * 测试 @BindsInstance用法，用@BindsInstance时，BuildModule2类构造方法不接收 Application application 参数，
 *  application 参数通过  provideUtils 方法的参数传入。
 */
@Module
public class BuildModule2 {

    public BuildModule2() {
    }

    /**
     * @return
     */
    @Provides
    public Utils provideUtils(Application application) {
        return new Utils(application);
    }


}
