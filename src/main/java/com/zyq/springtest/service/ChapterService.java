package com.zyq.springtest.service;

import com.zyq.springtest.bean.Chapter;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/2.
 */
public interface ChapterService {
    int deleteById(Integer id);

    int deleteByCourseId(Integer courseId);

    int addChapter(Chapter record);


    Chapter selectById(Integer id);

    List<Chapter> selectByCourseId(Integer id);

    List<Chapter> selectBySelective(Chapter record);

    int updateByPrimaryKeySelective(Chapter record);
}
