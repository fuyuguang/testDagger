package com.example.testdagger.component;

import android.app.Application;

import com.example.testdagger.MyApplication;
import com.example.testdagger.androidinjector.AndroidInjectorActivityComponent;
import com.example.testdagger.bean.Dog;
import com.example.testdagger.component_builder.BuildModule2;
import com.example.testdagger.dependencies.DependenciesActivity;
import com.example.testdagger.module.BuildersModule;
import com.example.testdagger.module.CommentModule;
import com.example.testdagger.subcomponent.ActivityComponent;
import com.example.testdagger.subcomponent.ActivityModule;
import com.example.testdagger.subcomponent.SubComponentActivity;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

//@Component(modules = {
////        MainActivityModule.class,
////        SecondActivityModule.class,
//        BuildersModule.class,
//        AndroidSupportInjectionModule.class
//})
//public interface MyAppComponent extends AndroidInjector<MyApplication>{
//
////    MyApplication inject(MyApplication application);
////
//    @Component.Builder
//    abstract  class Builder extends AndroidInjector.Builder<MyApplication>{}
//}

/**
 * MyAppComponent需要用 public 修饰，不然 MyApplication中拿不到 DaggerMyAppComponent
 */
@Component(modules = {
        /**
         * 抽象类，用 Map<Class<?>, AndroidInjector.Factory<?>>的方式收集所有的 注入的对象。
         */
        AndroidInjectionModule.class,
        /**
         * 被AndroidInjectionModule 修饰，
         * 它的构造方法被私有化了，
         * 该模块不再提供超出 {@link AndroidInjectionModule} 中提供的任何值，只是一个别名。 它将在未来的版本中删除。
         */
        AndroidSupportInjectionModule.class,
        /**
         *  抽象 的 module
         */
//        AndroidInjectorCustomModule.class, //或者用下边的BuildersModule.class
        BuildersModule.class,
        /**
         *  provider 方式提供的 module，
         */
        CommentModule.class,
//        /**
//         *  供 ThreeActivity 使用
//         */
//        ContributesAndroidInjectorMudule.class,
        /**
         * 测试Component.Builder
         */
        BuildModule2.class
})
public interface MyAppComponent {
    void inject(MyApplication application);


    /**
     * This function exposes the SecondActivityComponent Factory out of the graph so consumer can use it to obtain new instances of SecondActivityComponent
     * 此函数将 SecondActivityComponent Factory 从图中公开，因此使用者可以使用它来获取 SecondActivityComponent 的新实例
     *
     * @return
     */
    AndroidInjectorActivityComponent.Factory getSecondActivityComponent();

    /**
     * 将DogMudule中的  Dog 暴露出来，以便于 通过dependencies方式 依赖于 MyAppComponent 的Component调用
     * subComponent的方式，不需要暴露这个方法，就可以直接使用 {@link SubComponentActivity#mDog}
     *
     * {@link DependenciesActivity#mDog}
     * @return
     */
    Dog provideDog();


    /**
     * 演示subComponent ，ActivityComponent，SubComponentActivity
     * @param activityModule
     * @return
     */
    ActivityComponent addActivityComponent(ActivityModule activityModule);


    /**
     *
     * Builder是一种具有 {@linkplain Component#modules modules} 的 setter 方法的类型，
     *
     * 组件可能有一个嵌套的 {@code static abstract class} 或 {@code interface}
     *    {@code @Component.Builder} 注释。如果他们这样做了，（那么组件生成的构建器将匹配类型中的 API）那么 Dagger 将生成一个构建器
            实现该类型的类。请注意，带有 {@code @Component.Builder} 的组件可能也没有 {@code @Component.Factory}。
     * 通过使用 Component.Builder 来注解接口，Dagger 会自动生成跟上面完全相同的 Builder 类。可以自己去查看生成的 DaggerAppComponent 类。
     * 这种情况下加或不加Builder类都行，没有的话会自动生成
     * 如何实现自定义Builder类？ 这时候我们就需要使用到 @BindsInstance 注解了。
     */
//    @Component.Builder
//    interface Builder {
//        MyAppComponent build();
//        Builder buildModule(BuildModule buildModule);
//    }


    //测试@BindsInstance，用法，代替
    @Component.Builder
    interface Builder {
        MyAppComponent build();
        @BindsInstance
        Builder application(Application application);
        //由于BuildModule 类的构造方法需要application  参数，即使加上 @BindsInstance Builder application(Application application); 也需要new BuildModule(application)
        //Builder buildModule(BuildModule buildModule);
    }



//    /**
//     * @Component.Factory abstract methods must return the @Component type or a supertype of the @Component. Inherited method: create(T)，
//     */
//    @Component.Factory
//    public interface Builder extends AndroidInjector.Factory<MyAppComponent>{
//
//    }


//    /**
//     * 如下内容可有可无，如果没有的话， DaggerMyAppComponent 会自动创建， 也会创建相应的CommentModule
//     */
//    @Component.Builder
//    public interface Builder {
//        /**
//         * @Component.Builder types must have exactly one no-args method that  returns the @Component type    public interface Builder
//         * @Component.Builder 类型必须只有一个无参数方法，该方法返回 @Component
//         *  interface Builder 类中的 如下方法，必须要有
//         *  如下方法的方法名可以改，改后和 DaggerMyAppComponent.builder().build1222().inject(this); 中的 build1222()对应
//         */
//        MyAppComponent build1222();
//    }





}