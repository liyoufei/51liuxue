package com.sss.dao;

import com.sss.model.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectByEmail(String email);

    User selectByName(String name);

    int updateByEmail(User updateUser);
}