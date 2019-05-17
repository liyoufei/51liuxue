package com.sss.async.handler;

import com.sss.async.EventHandler;
import com.sss.async.EventModel;
import com.sss.async.EventType;
import com.sss.model.EntityType;
import com.sss.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class LoginExceptionHandler implements EventHandler {

    @Autowired
    MailService mailService;

    @Override
    public void doHandle(EventModel eventModel) {
        mailService.sendMail("liyoufei321@gmail.com","登录异常","您的账号竟在墙内登录！");
    }

    @Override
    public List<EventType> getSupportEventType() {
        return Arrays.asList(EventType.LOGIN);
    }
}
