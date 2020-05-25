package com.daop.security.mapper;

import com.daop.security.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.security.mapper
 * @Description :
 * @DATE : 2020-03-13  16:16
 * @AUTHOR : 杜先森
 **/
public interface UserMapper {
    /**
     * 通过用户名查找用户
     * @param username 用户名
     * @return 用户信息
     */
    User loadUserByUserName(@Param("username") String username);
}
