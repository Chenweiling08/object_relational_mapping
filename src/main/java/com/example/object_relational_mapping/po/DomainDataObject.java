package com.example.object_relational_mapping.po;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author:陈炜灵
 * @Date:2022/5/3 15:16
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainDataObject {
    String value();
   int num();
   String where();

}
