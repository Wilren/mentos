package com.wilren.mentos.mapper;

import com.wilren.mentos.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author wilren
 * @since 2018-10-11
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> listByUserId(Long id);
}
