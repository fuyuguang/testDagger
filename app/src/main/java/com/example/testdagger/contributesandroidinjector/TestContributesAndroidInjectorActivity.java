package com.example.testdagger.contributesandroidinjector;

import com.example.testdagger.BaseActivity;
import com.example.testdagger.module.BuildersModule;

import javax.inject.Inject;

/**
 * 测试 @ContributesAndroidInjector用法
 *
 * {@link BuildersModule#inject2()}
 */
public class TestContributesAndroidInjectorActivity extends BaseActivity {

//    @Inject
//    Usr mUser;

    /**
     * 独有的属性，在
     */
    @Inject
    ContributesAndroidInjectorBean mContributesAndroidInjectorBean;


    @Override
    protected void initView() {

//        txt1.append("  "+mUser.name )
          append(txt1," mContributesAndroidInjectorBean  : "+mContributesAndroidInjectorBean.toString());

    }

    @Override
    public boolean needAutoInject() {
        return true;
    }
}