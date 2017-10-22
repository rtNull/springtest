package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.User;
import com.zyq.springtest.dao.UserMapper;
import com.zyq.springtest.exception.LoginFailException;
import com.zyq.springtest.service.UserService;
import com.zyq.springtest.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhanyq on 2017/3/29.
 */
@Service
public class UserServiceImpl implements UserService {
    private final String salt = "hogriaeswgdasbljgfadsboi";
    @Autowired
    private UserMapper userMapper;

    public User userOAuthen(User record) {
        //判断是否已经授权
        User user = userMapper.selectByToken(record);
        if (user != null) {
            user.setPassword(null);
        }
        return user;
    }

    public boolean userExisted(User user) {
        //判断是否已经注册
        if (userMapper.selectByTel(user) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    public boolean regist(User user) {
        //校验信息
        if (user.getName() == null || user.getPassword() == null || user.getSex() == null || user.getRole() == null || user.getTel() == null) {
            return false;
        }
        //判断是否已经注册
        if (userMapper.selectByTel(user) != null) {
            return false;
        }
        if (userMapper.insert(user) > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 登录操作
     *
     * @param user
     * @return 返回带token的user
     */
    public User login(User user) {
        if (user.getTel() == null || user.getPassword() == null) {
            return null;
        }
        User userWithToken = userMapper.selectByTelAndPass(user);
        //用户密码是否正确
        if (userWithToken != null) {
            //ToDo 生成token，更新数据库并返回
            String token = Md5Util.encode(userWithToken.getTel() + userWithToken.getPassword() + salt);
            userWithToken.setToken(token);
            userWithToken.setPassword(null);//清空密码信息返回
            userMapper.updateByPrimaryKeySelective(userWithToken);
            return userWithToken;
        }
        return null;
    }

    /**
     * 教师登录操作
     *
     * @param user
     * @return
     * @throws LoginFailException
     */
    public User adminLogin(User user) throws LoginFailException {
        if (user.getTel() == null || user.getPassword() == null) {
            return null;
        }
        User userWithToken = userMapper.selectByTelAndPass(user);
        //用户密码是否正确
        if (userWithToken != null) {
            if (userWithToken.getRole() == 0) {
                return null;//学生角色
            }
            //ToDo 生成token，更新数据库并返回
            String token = Md5Util.encode(userWithToken.getTel() + userWithToken.getPassword() + salt);
            userWithToken.setToken(token);
            userWithToken.setPassword(null);//清空密码信息返回
            userMapper.updateByPrimaryKeySelective(userWithToken);
            return userWithToken;
        }
        return null;
    }

    /**
     * 更改用户信息
     *
     * @param user
     * @return
     */
    public User updateInfo(User user) {
        if (user.getToken() == null) {
            return null;
        }
        //根据token获得id
        User userOld = userMapper.selectByToken(user);
        if (userOld == null) {
            return null;
        }
        user.setId(userOld.getId());
        user.setTel(userOld.getTel());
        user.setHeadImg(userOld.getHeadImg());
        //密码不为空表示修改密码
        if (user.getPassword() != null) {
            String token = Md5Util.encode(user.getTel() + user.getPassword() + salt+System.currentTimeMillis());
            user.setToken(token);
        }
        //密码为空表示修改其他信息，校验其他信息密码为null

        if (userMapper.updateByPrimaryKeySelective(user) > 0) {
            user.setPassword(null);//清空密码信息返回
            return user;
        } else {
            return null;
        }
    }

    public int updateByPrimaryKeySelective(User record) {
        if (record == null ||
                record.getId() == null || record.getId() == 0) {
            return 0;
        }
        return userMapper.updateByPrimaryKeySelective(record);

    }

    public User selectByPrimaryKey(Integer id) {
        if (id == null || id == 0) {
            return null;
        }
        return userMapper.selectByPrimaryKey(id);
    }

}
