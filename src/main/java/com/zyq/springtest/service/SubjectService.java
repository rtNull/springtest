package com.zyq.springtest.service;

import com.zyq.springtest.bean.Subject;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/15.
 */
public interface SubjectService {
    int deleteByPrimaryKey(Integer id);

    int addSubject(Subject record);

    Subject selectByPrimaryKey(Integer id);

    List<Subject> selectAll();

    int updateByPrimaryKeySelective(Subject record);
}
