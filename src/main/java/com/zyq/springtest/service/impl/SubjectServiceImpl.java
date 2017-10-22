package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Subject;
import com.zyq.springtest.dao.SubjectMapper;
import com.zyq.springtest.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/15.
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    public int deleteByPrimaryKey(Integer id) {
        if (id == null || id == 0) return 0;
        return subjectMapper.deleteByPrimaryKey(id);
    }

    public int addSubject(Subject record) {
        if (record == null ||
                record.getSubjectName() == null || record.getSubjectName().trim().equals("")) {
            return 0;
        }
        return subjectMapper.insert(record);
    }

    public Subject selectByPrimaryKey(Integer id) {
        if (id == null || id == 0) return null;
        return subjectMapper.selectByPrimaryKey(id);
    }

    public List<Subject> selectAll() {
        return subjectMapper.selectAll();
    }

    public int updateByPrimaryKeySelective(Subject record) {
        if (record == null ||
                record.getId() == null || record.getId() == 0) {
            return 0;
        }
        return subjectMapper.updateByPrimaryKeySelective(record);
    }
}
