package com.daop.moredatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.moredatasource.config
 * @Description : 动态数据源配置
 * @DATE : 2020-04-04  10:13
 * @AUTHOR : 杜先森
 **/
@Component
@Configuration
public class DynamicDataSourcesConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.security")
    public DataSource security() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.test-master")
    public DataSource testMaster() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.druid.test-slave")
    public DataSource testSlave() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource security,DataSource testMaster,DataSource testSlave){
        Map<Object,Object> targetDataSource=new HashMap<>();
        targetDataSource.put("security",security);
        targetDataSource.put("test-master",testMaster);
        targetDataSource.put("test-slave",testSlave);
        return new DynamicDataSource(testMaster,targetDataSource);
    }
}
