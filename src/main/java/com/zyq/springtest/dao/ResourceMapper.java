package com.zyq.springtest.dao;

import com.zyq.springtest.bean.Resource;

import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByChapterId(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer id);

    List<Resource> selectBySelective(Resource record);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKeyWithBLOBs(Resource record);

    int updateByPrimaryKey(Resource record);
}