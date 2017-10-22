package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteBySubjectId(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    List<Course> selectByOffset(Integer offset);

    List<Course> selectBySelective(Course record);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKeyWithBLOBs(Course record);

    int updateByPrimaryKey(Course record);
}