package com.deli.demo.dom.mapper;

import com.deli.demo.dom.user.Gitstatistics;

public interface GitstatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Gitstatistics record);

    int insertSelective(Gitstatistics record);

    Gitstatistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gitstatistics record);

    int updateByPrimaryKey(Gitstatistics record);
}