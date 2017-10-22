package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Resource;
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
public class ResourceMapperTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ResourceMapper resourceMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        resourceMapper.deleteByPrimaryKey(11);

    }

    @Test
    public void deleteByChapterId() throws Exception {
        resourceMapper.deleteByChapterId(1);
    }

    @Test
    public void insert() throws Exception {
        Resource resource = new Resource(2, "面向对象ppt","ppt",new Date(),"193y45689y.jpg");
        resourceMapper.insert(resource);
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(resourceMapper.selectByPrimaryKey(6).toString());
    }

    @Test
    public void selectBySelective() throws Exception {
        Resource resource = new Resource();
        resource.setChapterId(1);
//        resource.setName("基础");
        resource.setType("ppt");
        logger.info(resourceMapper.selectBySelective(resource).toString());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Resource resource = new Resource();
        resource.setId(10);
        resource.setName("基础语法.doc");
        resource.setType("doc");
        resource.setDate(new Date());
        logger.info(resourceMapper.updateByPrimaryKeySelective(resource) + "");
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}