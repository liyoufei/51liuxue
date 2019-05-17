package com.sss.controller;

import com.sss.async.EventProducer;
import com.sss.common.ResultMsg;
import com.sss.common.UserContext;
import com.sss.model.User;
import com.sss.model.UserDetail;
import com.sss.service.UserDetailService;
import com.sss.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * UserController class
 *
 * @author Sss
 * @date 2019/3/26
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    EventProducer eventProducer;

    @RequestMapping(value = "/login")
    public String login(){
        return "user-login";
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "user-register";
    }

    /**
     * 用户注册操作
     * @param username
     * @param password
     * @param email
     * @param model
     * @return
     */
    @RequestMapping(value = "/register.do",method = {RequestMethod.POST})
    @ResponseBody
    public void register(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password,
                              @RequestParam(value = "email") String email,Model model){
        try{
            User user = new User();
            user.setName(username);
            user.setEmail(email);
            user.setPassword(password);
            ResultMsg resultMsg = userService.register(user);
        }catch(Exception e){

        }
    }

    /**
     * 用户点击链接进行认证
     * @param key
     */
    @RequestMapping(value = "/enable",method = RequestMethod.GET)
    public String enable(@RequestParam(value = "key") String key,Model model){
        User user = userService.enable(key);
        if(user != null){
            model.addAttribute("user",user);
            return "signup-success";
        }else{
            return "user-register";
        }
    }

    /**
     * 登录操作
     * @return
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(HttpServletRequest request,Model model){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email == null || password == null) {
            request.setAttribute("target", request.getParameter("target"));
            return "user-login";
        }
        User user = userService.auth(email,password);
        if(user != null){
            UserContext.setUser(user);
            model.addAttribute("user",user);
            return "redirect:/index";
        }else {
            return "user-login";
        }

    }

    /**
     * 注销操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        User user  = UserContext.getUser();
        userService.invalidate(user.getToken());
        return "redirect:/index";
    }






    /*
    *****************************************e*************用户个人信息更新**************************************
     */

    @RequestMapping(value = "/profile")
    public String profile(){
        return "user-center";
    }

    @RequestMapping(value = "/profile_setting")
    public String profileSetting(Model model){
        User user = UserContext.getUser();
        UserDetail userDetail  = userDetailService.findByUserId(user.getUserId());
        model.addAttribute("userDetail",userDetail);
        return "user-center-settings";
    }


    /**
     * 用户个人资料更新
     * @return 返回资料页面
     */
    @RequestMapping(value = "/profile_update",method = RequestMethod.POST)
    public String updateProfile(UserDetail userDetail){
        User user = UserContext.getUser();
        int userId = user.getUserId();
        userDetail.setUserId(userId);
        try{
            userDetailService.updateProfile(userDetail);
            return "redirect:/user/profile_setting";
        }catch(Exception e){
            logger.info(e.getMessage());
        }

        return "redirect:/index";
    }
}
