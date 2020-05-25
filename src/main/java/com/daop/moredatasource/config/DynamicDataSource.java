package com.daop.moredatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.moredatasource.config
 * @Description : 动态数据源
 * @DATE : 2020-04-04  10:12
 * @AUTHOR : 杜先森
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {
    public static final ThreadLocal<String> contextHolder=new ThreadLocal<>();
    public DynamicDataSource(DataSource defaultTargetDatasource, Map<Object, Object> targetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDatasource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();

    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDatasource();
    }
    public static void setDatasource(String datasource){
        contextHolder.set(datasource);
    }
    public static String getDatasource(){
        return contextHolder.get();
    }
    public static void clearDatasource(){
        contextHolder.remove();
    }
}
