package com.example.testdagger.component;

import com.example.testdagger.MyApplication;
import com.example.testdagger.module.BuildersModule;
import com.example.testdagger.module.CommentModule;
import com.example.testdagger.module.DogMudule;

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
//        SecondActivityModule.class,
        BuildersModule.class,
        /**
         *  provider 方式提供的 module，
         */
        CommentModule.class,
        /**
         *  供 ThreeActivity 使用
         */
        DogMudule.class,
})
public interface MyAppComponent {
    void inject(MyApplication application);


    /**
     * This function exposes the SecondActivityComponent Factory out of the graph so consumer can use it to obtain new instances of SecondActivityComponent
     * 此函数将 SecondActivityComponent Factory 从图中公开，因此使用者可以使用它来获取 SecondActivityComponent 的新实例
     *
     * @return
     */
    SecondActivityComponent.Factory getSecondActivityComponent();



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