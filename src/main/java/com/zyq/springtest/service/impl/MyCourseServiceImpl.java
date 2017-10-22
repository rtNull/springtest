package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.MyCourse;
import com.zyq.springtest.dao.MyCourseMapper;
import com.zyq.springtest.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by iYQZ on 2017/5/26.
 */
@Service
public class MyCourseServiceImpl implements MyCourseService {
    @Autowired
    private MyCourseMapper myCourseMapper;

    public int starCourse(MyCourse record) {
        if (record == null) {
            return 0;
        }
        if (record.getUserId() == null || record.getUserId() == 0
                || record.getCourseId() == null || record.getCourseId() == 0) {
            return 0;
        }
        return myCourseMapper.insert(record);
    }

    public int unStarCourse(MyCourse record) {
        if (record == null) {
            return 0;
        }
        if (record.getUserId() == null || record.getUserId() == 0
                || record.getCourseId() == null || record.getCourseId() == 0) {
            return 0;
        }
        return myCourseMapper.deleteMyCourse(record);
    }

    public List<MyCourse> myStarCourses(int userId) {
        if (userId == 0) {
            return null;
        }
        return myCourseMapper.selectMyCourse(userId);
    }

}
