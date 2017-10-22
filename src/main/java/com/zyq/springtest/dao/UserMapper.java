package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Chapter;
import com.zyq.springtest.bean.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByToken(User record);

    User selectByTel(User record);

    User selectByTelAndPass(User record);

    List<User> selectBySelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}