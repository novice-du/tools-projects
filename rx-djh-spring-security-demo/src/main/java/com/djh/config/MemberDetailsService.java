package com.djh.config;

import com.djh.entity.PermissionEntity;
import com.djh.entity.UserEntity;
import com.djh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dujunhua
 * @create: 2021/10/25 22:59
 * @description:
 */
@Component
public class MemberDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //1.userName查询账户是否存在
        UserEntity userEntity = userMapper.findByUsername(userName);
        if (userEntity == null) {
            System.out.println("用户不存在");
            return null;
        }
        //2.在根据该账户的userid关联查询角色对应权限动态添加
        List<PermissionEntity> userListPermission = userMapper.findPermissionByUsername(userName);
        // 设置的权限
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        userListPermission.forEach((item -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(item.getPermTag()));
        }));
        userEntity.setAuthorities(grantedAuthorities);
        return userEntity;
    }
}
