package com.daop.moredatasource.controller;

import com.daop.moredatasource.entiy.TestUser;
import com.daop.moredatasource.mapper.TestUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.moredatasource.controller
 * @Description :
 * @DATE : 2020-04-04  10:12
 * @AUTHOR : 杜先森
 **/
@RestController
public class UserController {
    @Autowired
    private TestUserMapper testUserMapper;
    @GetMapping("/{name}/list")
    public List<TestUser> list(@PathVariable("name") String name){
        if ("master".equals(name)){
            return testUserMapper.listUsersWithMaster();
        }else {
            return testUserMapper.listUsersWithSlave();
        }
    }
}
