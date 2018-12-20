package com.wilren.mentos.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/12/012
 */
@Component
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    LoginAuthenticationEntryPoint loginAuthenticationEntryPoint = new LoginAuthenticationEntryPoint("/login");


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // 从loginEntry中获取登录失败要跳转的url，并加上错误信息error
        String authenfailureUrl = this.loginAuthenticationEntryPoint.determineUrlToUseForThisRequest(request, response, exception);
        authenfailureUrl = authenfailureUrl + "?error";
        super.setDefaultFailureUrl(authenfailureUrl);
        super.onAuthenticationFailure(request, response, exception);
    }
}