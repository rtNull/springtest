package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Chapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhanyq on 2017/3/31.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ChapterMapperTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ChapterMapper chapterMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void deleteByCourseId() throws Exception {
    }

    @Test
    public void insert() throws Exception {
        Chapter chapter = new Chapter(1, "Java基础语法", new Date());
        chapterMapper.insert(chapter);

    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(chapterMapper.selectByPrimaryKey(1).toString());
    }

    @Test
    public void selectByCourseId() throws Exception {
        List<Chapter> chapterList = chapterMapper.selectByCourseId(1);
        logger.info(chapterList.toString());
    }

    @Test
    public void selectBySelective() throws Exception {
        Chapter chapter = new Chapter(1, "语法");
        chapter.setTitle(null);

        logger.info(chapterMapper.selectBySelective(chapter).toString());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Chapter chapter = new Chapter();
        chapter.setId(1);
        chapter.setTitle("Java发展与简介");
        chapterMapper.updateByPrimaryKeySelective(chapter);
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}