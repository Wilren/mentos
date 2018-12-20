package com.wilren.mentos.service.impl;

import com.wilren.mentos.entity.UserRole;
import com.wilren.mentos.mapper.UserRoleMapper;
import com.wilren.mentos.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色用户关系 服务实现类
 * </p>
 *
 * @author wilren
 * @since 2018-10-11
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
