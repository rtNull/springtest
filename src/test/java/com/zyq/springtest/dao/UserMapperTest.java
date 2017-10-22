package com.zyq.springtest.dao;

import com.zyq.springtest.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by zhanyq on 2017/3/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        User user = new User("13797002833", "wjj", "wjj", (byte) 0, (byte) 0);
        userMapper.insert(user);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {

    }

    @Test
    public void selectByToken() throws Exception {
        User user = new User();
        user.setToken("9776adaf96ff3ad6b49a98c12f6dfef7");
        System.out.print(userMapper.selectByToken(user));
    }

    @Test
    public void selectByTelAndPass() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}