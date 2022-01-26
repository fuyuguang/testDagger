package com.example.testdagger.lazy_provider;

import com.example.testdagger.BaseActivity;
import com.example.testdagger.module.BuildersModule;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

/**
 * 测试 Lazy 用法
 *[Dagger 2从浅到深(五)](https://blog.csdn.net/io_field/article/details/71122979)
 * {@link BuildersModule#inject2()}
 */
public class TestLazy_ProviderActivity extends BaseActivity {


    /**
     * Lazy只有第一次调用get()方法时，调用构造函数实例化对象，然后将该对象缓存。以后再调用get()方法时，都会返回缓存的实例，并且不会再调用构造函数，创建实例。
     */
    @Inject
    public  Lazy<BananaBean> mBananaBeanLazy;

    /**
     * 由于 GlobalBean  是单例的，类上加了 @ApplicationScope 注解，所以即便通过 Provider 来多次实例化，也都是同一个对象。
     */
    @Inject
    public Provider<GlobalBean> mGlobalBeanProvider;


    /**
     * BananaBean 类上没有scope
     */
    @Inject
    public Provider<BananaBean> mBananaBeanProvider;


    @Override
    protected void initView() {



        BananaBean beanA = mBananaBeanLazy.get();
        BananaBean beanB = mBananaBeanLazy.get();

        append(txt1," beanA.toString()  : "+beanA.toString());
        append(txt1," beanB.toString()  : "+beanB.toString());


        GlobalBean GlobalBean1 = mGlobalBeanProvider.get();
        GlobalBean GlobalBean2 = mGlobalBeanProvider.get();
        append(txt1," ");
        append(txt1," GlobalBean1.toString()  : "+GlobalBean1.toString());
        append(txt1," GlobalBean2.toString()  : "+GlobalBean2.toString());
        append(txt1," ");

        BananaBean bananaBean1 = mBananaBeanProvider.get();
        BananaBean bananaBean2 = mBananaBeanProvider.get();
        append(txt1," bananaBean1.toString()  : "+bananaBean1.toString());
        append(txt1," bananaBean2.toString()  : "+bananaBean2.toString());
    }

    @Override
    public boolean needAutoInject() {
        return true;
    }
}