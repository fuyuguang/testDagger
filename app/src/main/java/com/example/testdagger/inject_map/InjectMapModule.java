package com.example.testdagger.inject_map;


import com.example.testdagger.inject_set.InjectSetActivity;
import com.example.testdagger.inject_set.Person;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.LongKey;
import dagger.multibindings.StringKey;

@Module()
public class InjectMapModule {

    @Named("1")
    @IntoMap
    @StringKey("1")
    @Provides
    public Person providePerson1(){
        return new Person("guang,1");
    }


    @Named("2")
    @IntoMap()
    @IntKey(1)
    @Provides
    public Person providePerson2(){
        return new Person("guang,2");
    }

    @Provides
    @IntoMap
    @LongKey(1)
    public Person providePerson3(){
        return new Person("guang,3");
    }

    @Provides
    @IntoMap
    @ClassKey(InjectMapActivity.class)
    public Person providePerson4(){
        return new Person("guang,4");
    }



    //double data
    @Named("1")
    @IntoMap
    @StringKey("2")
    @Provides
    public Person providePerson5(){
        return new Person("guang,5");
    }



    @Named("2")
    @IntoMap()
    @IntKey(2)
    @Provides
    public Person providePerson6(){
        return new Person("guang,6");
    }

    /**
     * 提供相同返回值的依赖,会造成Dagger的“依赖迷失”,无法确定提供哪个依赖,用 QualifierType 来区分
     * @return
     */

    @Provides
    @IntoMap()
    @ComplexityKey(BigDecimal.class)
    public Person providePerson7(){
        return new Person("guang,7   ComplexityKey");
    }

    /**
     * 提供相同返回值的依赖,会造成Dagger的“依赖迷失”,无法确定提供哪个依赖,用 QualifierType 来区分
     * @return
     */
    @QualifierType("Complexity")
    @Provides
    @IntoMap()
    @ComplexityKey(BigDecimal.class)
    public Person providePerson8(){
        return new Person("guang,8   ComplexityKey");
    }
}
