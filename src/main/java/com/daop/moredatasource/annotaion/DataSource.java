package com.daop.moredatasource.annotaion;

import java.lang.annotation.*;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.moredatasource.annotaion
 * @Description : 自定义数据源选择注解
 * @DATE : 2020-04-03  23:28
 * @AUTHOR : 杜先森
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
