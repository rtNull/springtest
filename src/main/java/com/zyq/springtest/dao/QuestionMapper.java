package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Question;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByChapterId(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    List<Question> selectByChapterId(Integer id);

    List<Question> selectBySelective(Question record);

    int updateByPrimaryKeySelective(Question record);

}