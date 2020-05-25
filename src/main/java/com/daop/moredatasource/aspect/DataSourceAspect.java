package com.daop.moredatasource.aspect;

import com.daop.moredatasource.annotaion.DataSource;
import com.daop.moredatasource.config.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.moredatasource.aspect
 * @Description : 数据源切面
 * @DATE : 2020-04-04  10:11
 * @AUTHOR : 杜先森
 **/
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.daop.moredatasource.annotaion.DataSource)")
    public void dataSourcePointCut(){}
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature= (MethodSignature) point.getSignature();
        Method method=signature.getMethod();
        DataSource dataSource=method.getAnnotation(DataSource.class);
        if (dataSource==null) {
            DynamicDataSource.setDatasource("test-master");
        }else {
            DynamicDataSource.setDatasource(dataSource.name());
        }
        try {
            return point.proceed();
        }finally {
            DynamicDataSource.clearDatasource();
        }
    }
}
