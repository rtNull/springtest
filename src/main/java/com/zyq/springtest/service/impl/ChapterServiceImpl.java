package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Chapter;
import com.zyq.springtest.dao.ChapterMapper;
import com.zyq.springtest.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/14.
 */
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public int deleteById(Integer id) {
        if (id == null || id == 0) {
            return 0;
        }
        return chapterMapper.deleteByPrimaryKey(id);
    }

    public int deleteByCourseId(Integer id) {
        if (id == null || id == 0) {
            return 0;
        }
        return chapterMapper.deleteByCourseId(id);
    }

    public int addChapter(Chapter record) {
        if (record.getCourseId() == null || record.getCourseId() == 0 ||
                record.getTitle() == null || record.getTitle().trim().equals("") ||
                record.getCreateDate() == null) {
            return 0;
        }

        return chapterMapper.insert(record);
    }

    public Chapter selectById(Integer id) {
        if (id == null || id == 0) {
            return null;
        }
        return chapterMapper.selectByPrimaryKey(id);
    }

    public List<Chapter> selectByCourseId(Integer id) {
        if (id == null || id == 0) {
            return null;
        }
        return chapterMapper.selectByCourseId(id);
    }

    public List<Chapter> selectBySelective(Chapter record) {
        if (record == null) {
            return null;
        }
        return chapterMapper.selectBySelective(record);
    }

    public int updateByPrimaryKeySelective(Chapter record) {
        if (record == null || record.getId() == null || record.getId() == 0) {
            return 0;
        }
        return chapterMapper.updateByPrimaryKeySelective(record);
    }
}
