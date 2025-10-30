package com.zzzj.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//原注解
@Target(ElementType.METHOD)//表示这个注解只能加在方法上
@Retention(RetentionPolicy.RUNTIME)//这个注解在程序运行时生效
public @interface LogOperation{
}