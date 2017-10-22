package com.zyq.springtest.service;

import com.zyq.springtest.bean.MyCourse;
import com.zyq.springtest.bean.Subject;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/15.
 */
public interface MyCourseService {

    int starCourse(MyCourse record);

    int unStarCourse(MyCourse record);

    List<MyCourse> myStarCourses(int userId);

}
