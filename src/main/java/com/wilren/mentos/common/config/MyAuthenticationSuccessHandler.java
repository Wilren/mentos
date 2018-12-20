package com.wilren.mentos.common.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Wilren Chan
 * @version 1.0
 * @since 2018/10/23/023
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String requestURI = request.getRequestURI().replace(request.getContextPath(), "");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            System.out.println("loginUser:" + user.getUsername());
            //维护在session中
            request.getSession().setAttribute("userDetail", user);
            if (requestURI.indexOf("/admin/login") >= 0) {
                response.sendRedirect(request.getContextPath() + "/admin/index");
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }

        }
    }
}
