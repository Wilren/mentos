package com.wilren.mentos;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wilren.mentos.entity.User;
import com.wilren.mentos.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/26/026
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MentosTest {

    //@Resource
    private UserMapper mapper;

    //@Test
    public void testPage() {
        //System.out.println("------ 自定义 xml 分页 ------");
        //UserPage selectPage = new UserPage(1, 5).setSelectInt(20);
        //UserPage userPage = mapper.selectUserPage(selectPage);
        //Assert.assertSame(userPage, selectPage);
        //System.out.println("总条数 ------> " + userPage.getTotal());
        //System.out.println("当前页数 ------> " + userPage.getCurrent());
        //System.out.println("当前每页显示数 ------> " + userPage.getSize());
        //print(userPage.getRecords());


        System.out.println("------ baseMapper 自带分页 ------");
        Page<User> page = new Page<>(1, 5);
        User user = new User();
        user.setName("Wilren Chan");

        IPage<User> userIPage = mapper.selectPage(page, new QueryWrapper<User>(user));
        Assert.assertSame(userIPage, page);
        System.out.println("总条数 ------> " + userIPage.getTotal());
        System.out.println("当前页数 ------> " + userIPage.getCurrent());
        System.out.println("当前每页显示数 ------> " + userIPage.getSize());
        print(userIPage.getRecords());




    }

    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }


}
