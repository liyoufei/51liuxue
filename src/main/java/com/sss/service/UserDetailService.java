package com.sss.service;

import com.sss.dao.UserDetailMapper;
import com.sss.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * UserDetailService class
 *
 * @author Sss
 * @date 2019/4/3
 */

@Service
public class UserDetailService {

    @Autowired
    UserDetailMapper userDetailMapper;


    public boolean updateProfile(UserDetail userDetail){
        if(userDetailMapper.updateByUserId(userDetail) == 1){
            return true;
        }else {
            return false;
        }
    }


    public UserDetail findByUserId(int userId){
        return userDetailMapper.findByUserId(userId);
    }

    public void insertDetail(UserDetail userDetail) {
        userDetailMapper.insert(userDetail);
    }

}
