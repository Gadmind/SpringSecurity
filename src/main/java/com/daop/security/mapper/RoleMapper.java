package com.daop.security.mapper;

import com.daop.security.entity.Role;

import java.util.List;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.security.mapper
 * @Description : 角色表
 * @DATE : 2020-03-13  16:46
 * @AUTHOR : 杜先森
 **/
public interface RoleMapper {
    List<Role> listRolesById(Integer id);
}
