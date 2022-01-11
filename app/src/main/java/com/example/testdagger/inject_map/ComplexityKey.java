package com.example.testdagger.inject_map;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import dagger.MapKey;


@Retention(RUNTIME)
@MapKey
public @interface ComplexityKey {
    /**
     * True to use the value of the single member of the annotated annotation as the map key; false
     * to use the annotation instance as the map key.
     * <p>If true, the single member must not be an array.
     * True 使用注解注解的单个成员的值作为映射键；
     * false 将注释实例用作映射键。
     * 如果为 true，则单个成员不能是数组。
     * boolean unwrapValue() default true;
     */
    Class<? extends Number> value();
}
