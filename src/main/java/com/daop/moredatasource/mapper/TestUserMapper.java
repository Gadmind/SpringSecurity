package com.daop.moredatasource.mapper;

import com.daop.moredatasource.annotaion.DataSource;
import com.daop.moredatasource.entiy.TestUser;
import lombok.Data;

import java.util.List;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.moredatasource.mapper
 * @Description :
 * @DATE : 2020-04-04  10:14
 * @AUTHOR : 杜先森
 **/
public interface TestUserMapper {
    @DataSource(name = "test-master")
    List<TestUser> listUsersWithMaster();
    @DataSource(name = "test-slave")
    List<TestUser> listUsersWithSlave();
}
