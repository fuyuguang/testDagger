package com.example.testdagger.component;

import android.app.Activity;

import com.example.testdagger.SecondActivity;
import com.example.testdagger.module.SecondActivityModule;

import dagger.Binds;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * 这里出的问题，，Component不需要关联SecondActivityModule，
 * <p>
 * 错误写法 ：
 * @Subcomponent(modules = { SecondActivityModule.class,AndroidInjectionModule.class})
 * 如果关联会报错：(Execution failed for task ':app:compileDebugJavaWithJavac'. > java.lang.StackOverflowError)
 * <p>
 * 但需要关联AndroidInjectionModule , SecondActivityModule需要在AppComponent中注册
 */
@Subcomponent(modules = {AndroidInjectionModule.class})
public interface SecondActivityComponent extends AndroidInjector<SecondActivity> {

    /**
     * 方式1：
     */
    @Subcomponent.Factory
    public interface Factory extends AndroidInjector.Factory<SecondActivity> { }

//    /**
//     * 方式2：
//     *
//     * @Subcomponent.Factory 只能用来修饰接口，不能是抽象类 ，@Component也是
//     */
//    @Subcomponent.Factory
//    public interface Builder extends AndroidInjector.Factory<SecondActivity> { }


    /**
     *  @Subcomponent.Builder 只能用来修饰接口，不能是抽象类
     *
     *  子组件的构建器。这遵循 {@link Component.Builder} 的所有规则，只是它必须出现在用 {@link Subcomponent} 注释的类中，而不是 {@code Component}。
     *     如果子组件定义了构建器，其父组件将具有该构建器类型的绑定，允许从该组件上的方法注入或返回该构建器的实例或 {@code Provider}，就像任何 其他绑定。
     *
     *
     *     @Subcomponent.Builder setter methods must return void, the builder, or a supertype of the builder. Inherited method: create(T)
     *     @Subcomponent.Builder setter 方法必须返回 void、构建器或构建器的超类型。 继承方法：create(T)
     *
     */
//    @Subcomponent.Builder
//    public interface Builder extends AndroidInjector.Factory<SecondActivity> {
//        AndroidInjector.Factory<SecondActivity> build();
//    }


}

