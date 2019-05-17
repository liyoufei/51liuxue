package com.sss.interceptor;
import com.sss.common.UserContext;
import com.sss.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * AuthActionInterceptor class
 *
 * @author Sss
 * @date 2019/4/2
 */

@Component
public class AuthActionInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = UserContext.getUser();
        if(user == null){
            String msg = URLEncoder.encode("请先登录","utf-8");
            //获得登陆请求前的URL
            StringBuffer sb = request.getRequestURL();
            String target = URLEncoder.encode(sb.toString(),"utf-8");
            //参数返回登录前的页面
            if("GET".equalsIgnoreCase(request.getMethod())){
                response.sendRedirect("/user/login?errorMsg=" + msg + "&target=" + target);
            }else{
                response.sendRedirect("/user/login?errorMsg=" + msg);
            }

            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
