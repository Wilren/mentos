package com.wilren.mentos.service;

import com.wilren.mentos.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author wilren
 * @since 2018-10-11
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户id获取权限列表
     * @param userId    用户id
     * @return  角色列表
     */
    List<Role> listByUserId(Long userId);
}
