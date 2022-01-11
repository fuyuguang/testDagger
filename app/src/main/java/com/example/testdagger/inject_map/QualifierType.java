package com.example.testdagger.inject_map;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;


/**
 * 提供相同返回值的依赖,会造成Dagger的“依赖迷失”,无法确定提供哪个依赖
 * javax.inject.Named
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface QualifierType {
    /** The name. */
    String value() default "";
}
