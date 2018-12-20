package com.wilren.mentos.service.impl;

import com.wilren.mentos.entity.Role;
import com.wilren.mentos.mapper.RoleMapper;
import com.wilren.mentos.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author wilren
 * @since 2018-10-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Override
    public List<Role> listByUserId(Long userId) {
        return baseMapper.listByUserId(userId);
    }
}
