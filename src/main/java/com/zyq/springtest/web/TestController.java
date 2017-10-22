package com.zyq.springtest.web;

import com.zyq.springtest.bean.User;
import com.zyq.springtest.dto.CommentPair;
import com.zyq.springtest.dto.CoursePair;
import com.zyq.springtest.dto.Result;
import com.zyq.springtest.service.UserService;
import com.zyq.springtest.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhanyq on 2017/3/30.
 */
@Controller
@RequestMapping("/testmobile")
public class TestController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取json信息，返回json信息
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/registration")
    public @ResponseBody
    Result<User> register(@RequestBody User user) {
        logger.info("user{}", user);
        if (userService.userExisted(user)) {
            return new Result<User>(false, Constant.CODE_SIGNUP_FAILED_USESR_EXISTED);
        }
        if (userService.regist(user)) {
            return new Result<User>(true, user, Constant.CODE_SIGNUP_SUCCESS);
        } else {
            return new Result<User>(false, Constant.CODE_SIGNUP_FAILED);
        }
    }


    @RequestMapping(value = "/login")
    public @ResponseBody
    Result<User> login(User user) {
        logger.info("user{}", user);
        user = userService.login(user);
        if (user != null) {
            return new Result<User>(true, user, Constant.CODE_LOGIN_SUCCESS);
        } else {
            return new Result<User>(false, Constant.CODE_LOGIN_FAILED);
        }
    }
    @RequestMapping(value = "/teacherlogin")
    public @ResponseBody
    Result<User> teacherLogin(User user) {
        logger.info("user{}", user);
        user = userService.login(user);
        if (user != null&&user.getRole().byteValue()==1) {
            return new Result<User>(true, user, Constant.CODE_LOGIN_SUCCESS);
        } else {
            return new Result<User>(false, Constant.CODE_LOGIN_FAILED);
        }
    }
    @RequestMapping(value = "/updateUser")
    public @ResponseBody
    Result<User> updateUser(@RequestBody User user) {
        User userAuther = userService.userOAuthen(user);
        if (userAuther == null) {
            return new Result<User>(false, Constant.CODE_USESR_NOT_OAUTHEN);
        } else {
            user = userService.updateInfo(user);
            if (user != null) {
                return new Result<User>(true, user, Constant.CODE_UPDATE_USER_SUCCESS);
            } else {
                return new Result<User>(false, Constant.CODE_UPDATE_USER_FAILED);
            }
        }
    }

}
