package com.daop.security.service;

import com.daop.moredatasource.annotaion.DataSource;
import com.daop.security.entity.User;
import com.daop.security.mapper.RoleMapper;
import com.daop.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject ：Spring-boot-Security
 * @BelongsPackage ：com.daop.security
 * @Description : 用户业务
 * @DATE : 2020-03-13  16:14
 * @AUTHOR : 杜先森
 **/
@Service
public class UserServicesImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @DataSource(name = "security")
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        User user = userMapper.loadUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        } else {
            System.out.println(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            user.setRoles(roleMapper.listRolesById(user.getUid()));
        }
        return user;
    }
}
