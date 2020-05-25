package com.daop.security.entity;

import lombok.Data;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.security.entity
 * @Description : 响应格式
 * @DATE : 2020-03-13  16:04
 * @AUTHOR : 杜先森
 **/
@Data
public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    private RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static RespBean success(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean success(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }
}
