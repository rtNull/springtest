package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Comment;
import com.zyq.springtest.bean.Course;

import java.util.HashMap;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByCourseId(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectByOffsetAndCourseId(HashMap map);

    List<Comment> selectUnReadedByUserId(Integer id);

    List<Comment> selectBySelective(Comment record);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}