package com.nbdeli.demo.dom.blob.mapper;

import com.nbdeli.demo.dom.blob.entity.SystemConstant;

public interface SystemConstantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemConstant record);

    int insertSelective(SystemConstant record);

    SystemConstant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemConstant record);

    int updateByPrimaryKeyWithBLOBs(SystemConstant record);

    int updateByPrimaryKey(SystemConstant record);
}