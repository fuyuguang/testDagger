package com.example.testdagger.module;

import com.example.testdagger.SecondActivity;
import com.example.testdagger.ThreeActivity;
import com.example.testdagger.component.MyAppComponent;
import com.example.testdagger.component.SecondActivityComponent;
import com.example.testdagger.inject_map.InjectMapActivity;
import com.example.testdagger.inject_map.InjectMapModule;
import com.example.testdagger.inject_set.InjectSetModule;
import com.example.testdagger.inject_set.InjectSetActivity;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * 提供 abstract 的方法  contritution 的注解
 */
@Module(subcomponents = {SecondActivityComponent.class})
/**
 *  BuildersModule 类和里面的方法 要是  abstract的。
 *  参考自： [Dagger2 与 AndroidInjector](https://juejin.cn/post/6844903481027854344)
 */
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








    /**
     * 方式1： @ContributesAndroidInjector(modules = DogMudule.class)，此处指定 DogMudule.class ,,
     *  prodiverDog  方法 可以指定到统一的  CommentModule 类中使用。
     * @return
     */
    @ContributesAndroidInjector(modules = DogMudule.class)
    public abstract ThreeActivity inject2();


    /**
     * 方式2， ContributesAndroidInjector对应的modules，可以统一在 {@link MyAppComponent}类@Component中的{@link Component#modules()} 中注册
     *
     * 对于 java.util.Map<java.lang.Class<>、javax.inject.Provider<dagger.android.AndroidInjector.Factory<?>>>，同一个映射键被绑定了不止一次
     *
     * 返回的 ThreeActivity只能有一个，不然会报如上错误，，可以通过Named来指定？？？ 运行报错：@ContributesAndroidInjector methods cannot have qualifiers @Named("2")
     *
     *
     * @return
     */
//    @Named("type2")
//    @ContributesAndroidInjector()
//    public abstract ThreeActivity inject();





    @ContributesAndroidInjector(modules = InjectSetModule.class)
    public abstract InjectSetActivity injectSetActivity();


    @ContributesAndroidInjector(modules = InjectMapModule.class)
    public abstract InjectMapActivity injectMapActivity();
}
