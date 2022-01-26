package com.example.testdagger.module;

import com.example.testdagger.contributesandroidinjector.ContributesAndroidInjectorModule;
import com.example.testdagger.contributesandroidinjector.TestContributesAndroidInjectorActivity;
import com.example.testdagger.androidinjector.AndroidInjectorActivity;
import com.example.testdagger.component.MyAppComponent;
import com.example.testdagger.androidinjector.AndroidInjectorActivityComponent;
import com.example.testdagger.component_builder.FourActivity;
import com.example.testdagger.component_builder.FourActivityComponent;
import com.example.testdagger.inject_map.InjectMapActivity;
import com.example.testdagger.inject_map.InjectMapModule;
import com.example.testdagger.inject_set.InjectSetModule;
import com.example.testdagger.inject_set.InjectSetActivity;
import com.example.testdagger.lazy_provider.TestLazy_ProviderActivity;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * 提供 abstract 的方法  contritution 的注解,
 *
 * BuildersModule  引入的子component要在这里注册
 */
@Module(subcomponents = {AndroidInjectorActivityComponent.class,FourActivityComponent.class})
/**
 *  BuildersModule 类和里面的方法 要是  abstract的。
 *  参考自： [Dagger2 与 AndroidInjector](https://juejin.cn/post/6844903481027854344)
 */
public abstract class BuildersModule {

    /**
     * 方式1： public interface Factory extends AndroidInjector.Factory<SecondActivity> { }
     * 要和  {@link AndroidInjectorActivityComponent 中}
     * @Subcomponent.Factory
     * public interface Factory extends AndroidInjector.Factory<SecondActivity> { }
     * 对应
     */
    @Binds
    @IntoMap
    @ClassKey(AndroidInjectorActivity.class)
    public abstract AndroidInjector.Factory<?> bindSecondActivityInjectorFactory(AndroidInjectorActivityComponent.Factory builder);

    @Binds
    @IntoMap
    @ClassKey(FourActivity.class)
    public abstract AndroidInjector.Factory<?> bindFourActivityInjectorFactory(FourActivityComponent.Factory factory);


//    /**
//     * 方式2： interface Builder extends AndroidInjector.Factory<SecondActivity> { }， 和方式1的区别，仅仅是接口的名称不同而已！！！！！
//     *
//     * 方式1和方式2不能同时使用会报：
//     * java.lang.IllegalArgumentException: expected one element but was: <com.example.testdagger.androidinjector.SecondActivityComponent.Factory, com.example.testdagger.androidinjector.SecondActivityComponent.Builder>
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
    @ContributesAndroidInjector(modules = ContributesAndroidInjectorModule.class)
    public abstract TestContributesAndroidInjectorActivity inject2();


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




    @ContributesAndroidInjector()
    public abstract TestLazy_ProviderActivity testLazy_ProviderActivity();

}
