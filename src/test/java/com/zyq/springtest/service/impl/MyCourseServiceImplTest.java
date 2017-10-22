package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.MyCourse;
import com.zyq.springtest.dao.CommentMapper;
import com.zyq.springtest.dao.MyCourseMapper;
import com.zyq.springtest.service.MyCourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by iYQZ on 2017/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class MyCourseServiceImplTest {
    @Autowired
    private MyCourseMapper myCourseMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void starCourse() throws Exception {
        MyCourse myCourse = new MyCourse(1001, 1);
        logger.info(myCourseMapper.insert(myCourse) + "");
    }

    @Test
    public void unStarCourse() throws Exception {
        MyCourse myCourse = new MyCourse(1001, 1);
        logger.info(myCourseMapper.deleteMyCourse(myCourse) + "");
    }

    @Test
    public void myStarCourses() throws Exception {
        List<MyCourse> myCourses = myCourseMapper.selectMyCourse(100);
        if (myCourses != null) {
            logger.info(myCourses.toString());
        }
    }

}