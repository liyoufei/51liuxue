package com.sss.interceptor;

import com.google.common.base.Joiner;
import com.sss.common.CommonConstants;
import com.sss.common.UserContext;
import com.sss.model.User;
import com.sss.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * AuthInterceptor class
 *
 * @author Sss
 * @date 2019/4/2
 */
@Component
public class AuthInterceptor implements HandlerInterceptor{
    private static final String TOKEN = "token";


    @Autowired
    private UserService userService;


    /**
     * 用于做请求的用户检测 查看是否已经登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,String[]> map = request.getParameterMap();
        map.forEach((k,v) -> {
            request.setAttribute(k, Joiner.on(",").join(v));
        });
        String requestURI = request.getRequestURI();
        //静态资源的请求忽略
        if(requestURI.startsWith("/static") || requestURI.startsWith("/error")){
            return true;
        }
        Cookie cookie = WebUtils.getCookie(request,TOKEN);
        //获得到cookie中的token用其查询到user并存入上下文
        if(cookie != null && StringUtils.isNotBlank(cookie.getValue())){
            User user = userService.getLoginedUser(cookie.getValue());
            if(user != null){
                request.setAttribute(CommonConstants.LOGIN_USER_ATTRIBUTE,user);
                UserContext.setUser(user);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String requestURI = request.getRequestURI();
        if(requestURI.startsWith("/static") || requestURI.startsWith("/error")){
            return;
        }

        User user = UserContext.getUser();
        if(user != null && StringUtils.isNotBlank(user.getToken())){
            //若判断路径为logout请求，则将cookie相关字段移除
            String token = requestURI.startsWith("/user/logout")? "" : user.getToken();
            Cookie cookie = new Cookie(TOKEN,token);
            //设置为全局路径访问
            cookie.setPath("/");
            //设置为js可获取
            cookie.setHttpOnly(false);
            response.addCookie(cookie);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //视图渲染完成后将上下文中user移除
        UserContext.clear();
    }
}
