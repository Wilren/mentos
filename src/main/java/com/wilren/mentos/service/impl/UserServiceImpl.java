package com.wilren.mentos.service.impl;

import com.wilren.mentos.entity.User;
import com.wilren.mentos.mapper.UserMapper;
import com.wilren.mentos.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author wilren
 * @since 2018-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
