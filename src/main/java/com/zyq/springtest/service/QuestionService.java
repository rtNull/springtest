package com.zyq.springtest.service;

import com.zyq.springtest.bean.Question;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/2.
 */
public interface QuestionService {
    int deleteById(Integer id);

    int deleteByChapterId(Integer chapterId);

    int addQuestion(Question record);

    Question selectById(Integer id);

    List<Question> selectByChapterId(Integer id);

    List<Question> selectBySelective(Question record);

    int updateByPrimaryKeySelective(Question record);
}
