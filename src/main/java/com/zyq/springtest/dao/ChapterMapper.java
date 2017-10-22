package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Chapter;

import java.util.List;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByCourseId(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    List<Chapter> selectByCourseId(Integer id);

    List<Chapter> selectBySelective(Chapter record);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
}