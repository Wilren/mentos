package com.wilren.mentos.common.web;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/11/011
 */
public class BaseController {
    @Autowired
    private HttpServletRequest request;
    protected org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    /**
     * 获取用户角色
     *
     * @return 角色名
     */
    public List<String> getRole() {
        return null;
    }

    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    public Integer getUserId() {
        return null;
    }
}
