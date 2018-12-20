package com.wilren.mentos.controller.admin;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wilren.mentos.common.utils.Pagination;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wilren.mentos.entity.User;
import com.wilren.mentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import com.wilren.mentos.common.web.BaseController;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author wilren
 * @since 2018-10-12
 */
@Controller
@RequestMapping("/admin/user")
    public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = {"/listUser"})
    public String listUser(Model model) {
        return "admin/user/listUser";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/list"})
    public String list(Model model) {
        return "admin/user/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/infoUser"})
    public String infoUser(Model model) {
        return "admin/user/info";
    }

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return User
    */
    @GetMapping("/info")
    @ResponseBody
    public R<User> get(Long id) {
        return R.ok(userService.getById(id));
    }


    /**
    * 分页查询信息
    * @param user      查询实体
    * @param current   当前页
    * @param size      显示行数
    * @return
    */
    @RequestMapping("/page")
    @ResponseBody
    public Pagination page(User user, @RequestParam(value = "current") Integer current, @RequestParam(value = "size") Integer size) {
        Page<User> page = new Page<User>(current, size);
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<User>();
        if(StringUtils.isNotEmpty(user.getName())){
            qw.like(User::getName, user.getName());
        }
        System.out.println(qw.getSqlSegment());

        return new Pagination(userService.page(page, qw));
    }



    /**
     * 添加
     * @param  user  实体
     * @return success/false
     */
    @PostMapping("/save")
    @ResponseBody
    public R<User> save(User user) {
        Boolean result = userService.saveOrUpdate(user);
        if(result){
            user = userService.getById(user.getId());
            return R.ok(user);
        }else{
            return R.failed(ApiErrorCode.FAILED);
        }
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @PostMapping("/delete")
    @ResponseBody
    public R<Boolean> delete(Long id) {
        Boolean result = userService.removeById(id);
        if(result){
            return R.ok(result);
        }else{
            return R.failed(ApiErrorCode.FAILED);
        }
    }
}

