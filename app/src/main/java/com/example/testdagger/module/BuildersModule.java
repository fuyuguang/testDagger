package com.example.testdagger.module;

import android.app.Activity;

import com.example.testdagger.SecondActivity;
import com.example.testdagger.component.SecondActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * 提供 abstract 的方法  contritution 的注解
 */
@Module(subcomponents = SecondActivityComponent.class)
public abstract class BuildersModule {

    /**
     * 方式1： public interface Factory extends AndroidInjector.Factory<SecondActivity> { }
     * 要和  {@link SecondActivityComponent 中}
     * @Subcomponent.Factory
     * public interface Factory extends AndroidInjector.Factory<SecondActivity> { }
     * 对应
     */
    @Binds
    @IntoMap
    @ClassKey(SecondActivity.class)
    public abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Factory builder);


//    /**
//     * 方式2： interface Builder extends AndroidInjector.Factory<SecondActivity> { }， 和方式1的区别，仅仅是接口的名称不同而已！！！！！
//     *
//     * 方式1和方式2不能同时使用会报：
//     * java.lang.IllegalArgumentException: expected one element but was: <com.example.testdagger.component.SecondActivityComponent.Factory, com.example.testdagger.component.SecondActivityComponent.Builder>
//     *
//     * 要和 SecondActivityComponent中
//     * @Subcomponent.Factory
//     * public interface Builder extends AndroidInjector.Factory<SecondActivity> { }
//     * 对应
//     */
//    @Binds
//    @IntoMap
//    @ClassKey(SecondActivity.class)
//    public abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);


//    /**
//     * 这种方式不行，报
//     * @Binds 方法的参数类型必须可分配给返回类型 public abstract AndroidInjector.Builder<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);
//     * @Binds methods' parameter type must be assignable to the return type public abstract AndroidInjector.Builder<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);
//     */
//    @Binds
//    @IntoMap
//    @ClassKey(SecondActivity.class)
//    public abstract AndroidInjector.Builder<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);

}
