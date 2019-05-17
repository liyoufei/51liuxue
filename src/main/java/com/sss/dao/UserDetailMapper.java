package com.sss.dao;

import com.sss.model.UserDetail;
import java.util.List;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDetail record);

    UserDetail selectByPrimaryKey(Integer id);

    List<UserDetail> selectAll();

    int updateByPrimaryKey(UserDetail record);

    UserDetail findByUserId(int userId);

    int updateByUserId(UserDetail userDetail);
}