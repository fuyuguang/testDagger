package com.example.testdagger.inject_set;


import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

@Module()
public class InjectSetModule {

    @Named("1")
    @Provides
    public Person providePerson1(){
        return new Person("guang,1");
    }


    @Named("2")
    @IntoSet
    @Provides
    public Person providePerson2(){
        return new Person("guang,2");
    }

    @Named("3")
    @IntoSet
    @Provides
    public Person providePerson3(){
        return new Person("guang,3");
    }

    @Provides
    @IntoSet
    public Person providePerson4(){
        return new Person("guang,4");
    }

    @Provides
    @IntoSet
    public Person providePerson5(){
        return new Person("guang,5");
    }


    @Provides
    /**
     *
     *  使用 @IntoSet 这个注解不行，注入不到 {@link InjectSetActivity.set 中}
     */
    @ElementsIntoSet
    /**
     *
     * 方法的返回值只能是  Set<Person>，不然报错
     * 错误: @Provides methods annotated with @ElementsIntoSet must return a Set public TreeSet<Person> providePersonSet()
     */
    public Set<Person> providePersonSet(){
        /**
         * 用TreeSet  会报 Caused by: java.lang.ClassCastException:
         * com.example.testdagger.injectcollection.Person cannot be cast to java.lang.Comparable，
         *
         */
        //Set<Person> set = new TreeSet();
        HashSet<Person> set = new HashSet();
        set.add(new Person("guang_,6"));
        set.add(new Person("guang_,7"));
        set.add(new Person("guang_,8"));
        return set;
    }
}
