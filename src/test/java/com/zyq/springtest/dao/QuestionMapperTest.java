package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhanyq on 2017/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class QuestionMapperTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private QuestionMapper questionMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
        questionMapper.deleteByPrimaryKey(8);
    }

    @Test
    public void deleteByChapterId() throws Exception {
        questionMapper.deleteByChapterId(1);
    }

    @Test
    public void insert() throws Exception {
        Question question = new Question(3, false, "插入填空题成功了吗？", "不知道，在测试", "o,I know!");
        questionMapper.insert(question);

    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
        logger.info(questionMapper.selectByPrimaryKey(6).toString());
    }

    @Test
    public void selectByChapterId() throws Exception {
        logger.info(questionMapper.selectByChapterId(1).toString());

    }


    @Test
    public void selectBySelective() throws Exception {
        Question question = new Question();
        question.setIschoice(false);
        logger.info(questionMapper.selectBySelective(question).toString());
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
        Question question = new Question();
        question.setId(6);
        question.setExplanation("这是插入测试");
        questionMapper.updateByPrimaryKeySelective(question);
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

}