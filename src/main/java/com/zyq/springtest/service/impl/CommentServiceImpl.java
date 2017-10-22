package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Comment;
import com.zyq.springtest.dao.CommentMapper;
import com.zyq.springtest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhanyq on 2017/4/14.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    public int deleteById(Integer id) {
        if (id==null||id==0) return 0;
        return commentMapper.deleteByPrimaryKey(id);
    }

    public int deleteByCourseId(Integer id) {
        if (id==null||id==0) return 0;
        return commentMapper.deleteByCourseId(id);
    }

    public int addComment(Comment record) {
        if (record == null ||
                record.getCourseId() == null || record.getCourseId() == 0 ||
                record.getUserId() == null || record.getUserId() == 0 ||
                record.getContent() == null || record.getContent().trim().equals("") ||
                record.getCommentTime() == null) {
            return 0;
        }
        return commentMapper.insert(record);
    }

    public Comment selectById(Integer id) {
        if (id==null||id==0) return null;
        return commentMapper.selectByPrimaryKey(id);
    }

    public List<Comment> selectByPageNumAndCourseId(Integer pageNum, Integer courseId) {
        if (pageNum == null || pageNum == 0) {
            return null;
        }
        int offset = (pageNum - 1) * 10;
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("courseId", courseId);
        hashMap.put("offset", offset);
        return commentMapper.selectByOffsetAndCourseId(hashMap);
    }

    public List<Comment> selectUnReadedByUserId(Integer id) {
        if (id == null || id == 0) {
            return null;
        }
        return commentMapper.selectUnReadedByUserId(id);
    }

    public List<Comment> selectBySelective(Comment record) {
        if (record==null) return null;
        return commentMapper.selectBySelective(record);
    }

    public int updateByPrimaryKeySelective(Comment record) {
        if (record == null || record.getId() == null || record.getId() == 0) {
            return 0;
        }
        return commentMapper.updateByPrimaryKeySelective(record);
    }
}
