package com.zyq.springtest.service;

import com.zyq.springtest.bean.User;
import com.zyq.springtest.exception.LoginFailException;
import com.zyq.springtest.exception.UpdateFailException;
import com.zyq.springtest.exception.UserRegistedException;

/**
 * Created by zhanyq on 2017/3/29.
 */
public interface UserService {
    public User userOAuthen(User user);

    public boolean userExisted(User user);

    public boolean regist(User user) throws UserRegistedException;

    public User login(User user) throws LoginFailException;

    public User adminLogin(User user) throws LoginFailException;

    public User updateInfo(User user) throws UpdateFailException;

    public int updateByPrimaryKeySelective(User record);

    public User selectByPrimaryKey(Integer id);
}
