package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Course;
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
 * Created by zhanyq on 2017/3/31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CourseMapperTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        courseMapper.deleteByPrimaryKey(6);
    }

    @Test
    public void deleteBySubjectId() throws Exception {
        courseMapper.deleteBySubjectId(3);
    }

    @Test
    public void insert() throws Exception {
        Course course = new Course(1, 1003, "演员的自我修养");
        courseMapper.insert(course);

    }

    @Test
    public void insertSelective() throws Exception {
        Course course = new Course();
        course.setSubjectId(1);
        course.setUserId(1001);
        courseMapper.insertSelective(course);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(courseMapper.selectByPrimaryKey(6).toString());
    }

    @Test
    public void selectByOffset() throws Exception {
        logger.info(courseMapper.selectByOffset(0).toString());
    }

    @Test
    public void selectBySelective() throws Exception {
        Course course = new Course();
        course.setCourseName("设计");
        List<Course> courseList = courseMapper.selectBySelective(course);
        logger.info("couserList{}", courseList);
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Course course = new Course();
        course.setId(12);
        course.setCourseName("Java程序设计");
        courseMapper.updateByPrimaryKeySelective(course);

    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}