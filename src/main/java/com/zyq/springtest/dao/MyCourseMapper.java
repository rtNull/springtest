package com.zyq.springtest.dao;

import com.zyq.springtest.bean.MyCourse;

import java.util.List;

public interface MyCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteBySelective(MyCourse record);

    int deleteMyCourse(MyCourse record);


    int insert(MyCourse record);

    int insertSelective(MyCourse record);

    MyCourse selectByPrimaryKey(Integer id);

    List<MyCourse> selectBySelective(MyCourse record);

    List<MyCourse> selectMyCourse(Integer userId);


    int updateByPrimaryKeySelective(MyCourse record);

    int updateByPrimaryKey(MyCourse record);
}