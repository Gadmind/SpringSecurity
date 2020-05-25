package com.daop.security.entity;

import java.io.Serializable;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.security.entity
 * @Description : 角色表
 * @DATE : 2020-03-13  14:08
 * @AUTHOR : 杜先森
 **/
public class Role implements Serializable {
    private int rid;
    private String name;
    private String rolename;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
