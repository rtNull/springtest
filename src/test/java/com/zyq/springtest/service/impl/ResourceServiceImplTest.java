package com.zyq.springtest.service.impl;

import com.zyq.springtest.dao.ResourceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by zhanyq on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class ResourceServiceImplTest {
    @Autowired
    private ResourceMapper resourceMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void deleteByChapterId() throws Exception {

        logger.info( resourceMapper.deleteByChapterId(3)+"");
    }

    @Test
    public void addResource() throws Exception {
    }

    @Test
    public void selectById() throws Exception {
    }

    @Test
    public void selectBySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

}