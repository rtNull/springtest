package com.zyq.springtest.service;

import com.zyq.springtest.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhanyq on 2017/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void regist() throws Exception {
        User user = new User("13797002855", "zgc", "zgc");
        System.out.print(userService.regist(user));
    }

    @Test
    public void login() throws Exception {
        User user = new User("13797002833", "wjj");
        user = userService.login(user);
        System.out.println(user);
    }

    @Test
    public void updateInfo() throws Exception {
        User user = new User("13797002811", null);
        user.setToken("580f2bda9ab68c3548e8a1a5eb263c1f");
        user.setIntroduction("I love photography2");
        System.out.println(userService.updateInfo(user));
    }

}