package com.sss;

import com.sss.model.User;
import com.sss.service.UserService;
import com.sss.util.BeanHelper;
import com.sss.util.HashUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    UserService userService;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("1");
        user.setPassword("1");
        user.setEmail("1");
        String password = HashUtil.encryPassword(user.getPassword());
        System.out.println(password);
        user.setPassword(password);
        user.setSalt(HashUtil.SALT);
        BeanHelper.onInsert(user);
        user.setAvatarUrl("http://127.0.0.1:8081/1545649869/IMG_3052.JPG");
        user.setStatus(new Byte("0"));
        userService.addAccount(user);
    }

}
