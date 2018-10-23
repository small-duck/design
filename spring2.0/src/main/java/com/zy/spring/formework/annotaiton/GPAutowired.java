package com.zy.spring.formework.annotaiton;

import java.lang.annotation.*;

/**
 * @ClassName GPAutowired
 * @Description 自动注入
 * @Author Benny
 * @Date 2018/8/26 0026 11:02
 * @Version 1.0
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {

    String value() default "";
}
