package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Subject;

import java.util.List;

public interface SubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    List<Subject> selectAll();

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}