package com.zyq.springtest.service.impl;

import com.zyq.springtest.bean.Resource;
import com.zyq.springtest.dao.ResourceMapper;
import com.zyq.springtest.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/14.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public int deleteById(Integer id) {
        if (id == null || id == 0) return 0;
        return resourceMapper.deleteByPrimaryKey(id);
    }

    public int deleteByChapterId(Integer id) {
        if (id == null || id == 0) return 0;
        return resourceMapper.deleteByChapterId(id);
    }

    public int addResource(Resource record) {
        if (record == null || record.getChapterId() == null
                || record.getChapterId() == 0 || record.getName() == null
                || record.getName().trim().equals("") || record.getUrl() == null) {
            return 0;
        }
        return resourceMapper.insert(record);
    }

    public Resource selectById(Integer id) {
        if (id == null || id == 0) return null;
        return resourceMapper.selectByPrimaryKey(id);
    }

    public List<Resource> selectBySelective(Resource record) {
        if (record == null) {
            return null;
        }
        return resourceMapper.selectBySelective(record);
    }

    public int updateByPrimaryKeySelective(Resource record) {
        if (record == null || record.getId() == null || record.getId() == 0) {
            return 0;
        }
        return resourceMapper.updateByPrimaryKeySelective(record);
    }
}
