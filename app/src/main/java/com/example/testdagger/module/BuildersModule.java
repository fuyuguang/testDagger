package com.example.testdagger.module;

import android.app.Activity;

import com.example.testdagger.FourActivity;
import com.example.testdagger.SecondActivity;
import com.example.testdagger.ThreeActivity;
import com.example.testdagger.component.SecondActivityComponent;
import com.example.testdagger.component.ThreeActivityComponent;

import java.util.Random;

import javax.inject.Provider;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SecondActivityComponent.class,ThreeActivityComponent.class})
public abstract class BuildersModule {


    @Binds
    @IntoMap
    @ClassKey(SecondActivity.class)
    public abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(SecondActivityComponent.Builder builder);


    /**
     *Binds 必须用来注解抽象方法，可以和  Scope，Qualifier一起使用，方法的返回值通常为该方法参数的父类或接口，参数为具体的实现类。 参数的实现 封装在DispatchingAndroidInjector类中的injectorFactories 中，
     *Map<String, Provider<AndroidInjector.Factory<?>>> key 通过 @ClassKey的值  ThreeActivity.class 转String指定 ， 值作为 DaggerMyAppComponent类的成员变量 Provider
     *Provider<ThreeActivityComponent.Builder> threeActivityComponentBuilderProvider 由 dagger自动生成并提供
     *
     * @Binds注释Module中的抽象方法，来实现委托绑定，它是对 {@link Provides} 方法的直接替代（接收一个实现类作为参数，返回一个父类或接口的方法）
     *
     * 需要和IntoSet，ElementsIntoSet， IntoMap配合使用
     * @param builder
     * @return
     */
    @Binds
    /**
     * 该方法的返回类型为{@code Map<K, Provider<V>>}，
     * 该注解需要和@ClassKey 共同使用， @ClassKey指定的内容为key，如下方法的返回值作为May的value ，作为一个组合贡献到dagger的对象依赖图中。
     * 键/值对。 值累积产生的 {@code Map<K, Provider<V>>} 将是不可变。
     * @see <a href="https://dagger.dev/multibindings#map-multibindings">Map multibinding</a>
     */
    @IntoMap
    /**
     * 带有 @MapKey的  @ClassKey，用来供ma使用
     */
    @ClassKey(ThreeActivity.class)
    public abstract AndroidInjector.Factory<?> bindThreadActivityInjectorFactory(ThreeActivityComponent.Builder builder);

    /**
     *  ContributesAndroidInjector 代替了 FourComponent , 用 ContributesAndroidInjector 注解相应的方法，方法的返回类型为注入类，注入到该类需要的
     *  实例或对象由 ContributesAndroidInjector注解的参数 modules 提供 （xxxModule类似于工厂类，生产相应的对象）。
     * @return
     */
    @ContributesAndroidInjector(modules = FourActivityModule.class)
    public abstract FourActivity bindFourActivityInject();
}
