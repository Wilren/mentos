package com.wilren.mentos.common.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
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
public class LoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private Map<String, String> authEntryPointMap;

    private PathMatcher pathMatcher = new AntPathMatcher();


    public LoginAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        super.commence(request, response, authException);
    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        authEntryPointMap = new HashMap<>();
        authEntryPointMap.put("/**","/login");
        authEntryPointMap.put("/admin/**","/admin/login");

        String requestURI = request.getRequestURI().replace(request.getContextPath(), "");
        for (String url : this.authEntryPointMap.keySet()) {
            if (this.pathMatcher.match(url, requestURI)) {
                return this.authEntryPointMap.get(url);
            }
        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}
