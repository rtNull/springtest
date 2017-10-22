package com.zyq.springtest.service;

import com.zyq.springtest.bean.Resource;

import java.util.List;

/**
 * Created by zhanyq on 2017/4/2.
 */
public interface ResourceService {
    int deleteById(Integer id);

    int deleteByChapterId(Integer chapterId);

    int addResource(Resource record);


    Resource selectById(Integer id);

    List<Resource> selectBySelective(Resource record);

    int updateByPrimaryKeySelective(Resource record);

}
