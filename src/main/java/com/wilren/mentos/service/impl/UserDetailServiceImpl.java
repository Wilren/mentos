package com.wilren.mentos.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wilren.mentos.common.constants.SecurityConstants;
import com.wilren.mentos.entity.Role;
import com.wilren.mentos.entity.User;
import com.wilren.mentos.service.RoleService;
import com.wilren.mentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/11/011
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getLoginName, username));
        List<Role> roles = null;
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user != null) {
            // 查询用户权限
            roles = roleService.listByUserId(user.getId());
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getCode()));
            }
            authorities.add(new SimpleGrantedAuthority(SecurityConstants.BASE_ROLE));
        } else {
            throw new UsernameNotFoundException("找不到用户");
        }
        return new org.springframework.security.core.userdetails.User(user.getLoginName(), user.getPassword(), authorities);
    }
}
