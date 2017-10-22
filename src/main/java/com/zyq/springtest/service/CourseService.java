package com.zyq.springtest.service;

import com.zyq.springtest.bean.Course;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/2.
 */
public interface CourseService {
    int deleteCourseById(Integer id);

    int deleteBySubjectId(Integer id);

    int addCourse(Course record);

    Course selectById(Integer id);

    List<Course> selectBySelective(Course record);

    List<Course> selectByPageNum(Integer pageNum);

    int updateByPrimaryKeySelective(Course record);

}
