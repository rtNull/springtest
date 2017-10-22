package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Question;
import com.zyq.springtest.dao.QuestionMapper;
import com.zyq.springtest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/14.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    public int deleteById(Integer id) {
        if (id == null || id == 0) return 0;
        return questionMapper.deleteByPrimaryKey(id);
    }

    public int deleteByChapterId(Integer id) {
        if (id == null || id == 0) return 0;
        return questionMapper.deleteByChapterId(id);
    }

    public int addQuestion(Question record) {
        if (record == null ||
                record.getChapterId() == null || record.getChapterId() == 0 || record.getTitle() == null || record.getAnswer() == null) {
            return 0;
        }
        if (record.getIschoice()==null) {
            return 0;
        }
        if (record.getIschoice()) {
            if (record.getOptionA() == null || record.getOptionA().trim().equals("")||
                    record.getOptionB() == null || record.getOptionB().trim().equals("")||
                    record.getOptionC() == null || record.getOptionC().trim().equals("")||
                    record.getOptionD() == null || record.getOptionD().trim().equals("")) {
                return 0;
            }
        }
        return questionMapper.insert(record);
    }

    public Question selectById(Integer id) {
        if (id == null || id == 0){  return null;}
        return questionMapper.selectByPrimaryKey(id);
    }

    public List<Question> selectByChapterId(Integer id) {
        if (id == null || id == 0){  return null;}
        return questionMapper.selectByChapterId(id);
    }

    public List<Question> selectBySelective(Question record) {
        if (record == null) {
            return null;
        }
        return questionMapper.selectBySelective(record);
    }

    public int updateByPrimaryKeySelective(Question record) {
        if (record == null || record.getId() == null || record.getId() == 0) {
            return 0;
        }
        return questionMapper.updateByPrimaryKeySelective(record);
    }
}
