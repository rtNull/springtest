package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Course;
import com.zyq.springtest.dao.CourseMapper;
import com.zyq.springtest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/14.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public int deleteCourseById(Integer id) {
        if (id == null || id == 0) return 0;
        return courseMapper.deleteByPrimaryKey(id);
    }

    public int deleteBySubjectId(Integer id) {
        if (id == null || id == 0) return 0;
        return courseMapper.deleteBySubjectId(id);
    }

    public int addCourse(Course record) {
        if (record.getSubjectId() == null || record.getSubjectId() == 0 || record.getUserId() == null || record.getUserId() == 0 || record.getCourseName() == null) {
            return 0;
        }
        return courseMapper.insert(record);
    }

    public Course selectById(Integer id) {
        if (id == null || id == 0) return null;
        return courseMapper.selectByPrimaryKey(id);
    }

    public List<Course> selectBySelective(Course record) {
        if (record == null) {
            return null;
        }
        return courseMapper.selectBySelective(record);
    }

    public List<Course> selectByPageNum(Integer pageNum) {
        if (pageNum == null || pageNum == 0) {
            return null;
        }
        int offset = (pageNum - 1) * 10;
        return courseMapper.selectByOffset(offset);
    }

    public int updateByPrimaryKeySelective(Course record) {
        if (record == null || record.getId() == 0) {
            return 0;
        }
        return courseMapper.updateByPrimaryKeySelective(record);
    }

}
