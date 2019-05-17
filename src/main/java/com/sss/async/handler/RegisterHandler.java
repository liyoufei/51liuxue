package com.sss.async.handler;

import com.sss.async.EventHandler;
import com.sss.async.EventModel;
import com.sss.async.EventType;
import com.sss.model.User;
import com.sss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * RegisterHandler class
 *
 * @author Sss
 * @date 2019/4/3
 */
@Component
public class RegisterHandler implements EventHandler {

    @Autowired
    UserService userService;

    @Override
    public void doHandle(EventModel eventModel) {
        User user = userService.getUserById(eventModel.getEntityOwnerId());
        userService.registerNotify(user.getEmail());
    }

    @Override
    public List<EventType> getSupportEventType() {
        return Arrays.asList(EventType.REGISTER);
    }
}
