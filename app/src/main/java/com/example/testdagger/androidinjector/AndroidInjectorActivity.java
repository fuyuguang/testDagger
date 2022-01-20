package com.example.testdagger.androidinjector;

import com.example.testdagger.BaseActivity;

import javax.inject.Inject;
import javax.inject.Named;

public class AndroidInjectorActivity extends BaseActivity {

    @Inject
    public Usr mUser;

    @Named("1")
    @Inject
    public Person mperson;



    @Override
    protected void initView() {
        txt1.setText(TAG+"   "+mUser.name);
        txt1.append("\n"+mperson.toString());
    }

    @Override
    public boolean needAutoInject() {
        return true;
    }
}