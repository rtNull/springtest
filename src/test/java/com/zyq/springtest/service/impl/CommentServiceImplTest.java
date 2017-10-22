package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Comment;
import com.zyq.springtest.dao.CommentMapper;
import com.zyq.springtest.dao.ResourceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by zhanyq on 2017/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class CommentServiceImplTest {
    @Autowired
    private CommentMapper commentMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteByCourseId() throws Exception {
    }

    @Test
    public void addComment() throws Exception {
        for (int i = 0; i < 20; i++) {
            commentMapper.insert(new Comment(1, 1006, new Date(), "comment Java" + i));
        }
    }

    @Test
    public void selectById() throws Exception {
    }

    @Test
    public void selectByPageNumAndCourseId() throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("courseId", 1);
        hashMap.put("offset", 0);
        logger.info(commentMapper.selectByOffsetAndCourseId(hashMap).toString());

    }

    @Test
    public void selectUnReadedByUserId() throws Exception {
        logger.info(commentMapper.selectUnReadedByUserId(1001).toString());
    }

    @Test
    public void selectBySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

}