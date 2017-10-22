package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by zhanyq on 2017/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CommentMapperTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        commentMapper.deleteByPrimaryKey(1);
    }

    @Test
    public void deleteByCourseId() throws Exception {
        commentMapper.deleteByCourseId(1);
    }

    @Test
    public void insert() throws Exception {
        Comment comment = new Comment(1, 1001, new Date(), "老师教得很好2");
        commentMapper.insert(comment);
    }

    @Test
    public void insertSelective() throws Exception {
        Comment comment = new Comment(1, 1003, 1001, new Date(), false, "感觉还行");
        commentMapper.insert(comment);
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(commentMapper.selectByPrimaryKey(1).toString());

    }

    @Test
    public void selectBySelective() throws Exception {
        Comment comment = new Comment();
        comment.setToUserId(1001);
        comment.setReaded(false);
        logger.info("comments{}", commentMapper.selectBySelective(comment));
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Comment comment = new Comment();
        comment.setId(3);
        comment.setReaded(true);
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}