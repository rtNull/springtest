package com.zyq.springtest.service;

import com.zyq.springtest.bean.Comment;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/2.
 */
public interface CommentService {
    int deleteById(Integer id);

    int deleteByCourseId(Integer id);

    int addComment(Comment record);

    Comment selectById(Integer id);

    List<Comment> selectByPageNumAndCourseId(Integer pageNum, Integer courseId);

    List<Comment> selectUnReadedByUserId(Integer id);

    List<Comment> selectBySelective(Comment record);

    int updateByPrimaryKeySelective(Comment record);

}
