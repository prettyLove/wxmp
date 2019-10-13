package com.kochun.dao;

import com.kochun.model.SystemModule;
import com.kochun.model.SystemModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemModuleMapper {
    long countByExample(SystemModuleExample example);

    int deleteByExample(SystemModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemModule record);

    int insertSelective(SystemModule record);

    List<SystemModule> selectByExample(SystemModuleExample example);

    SystemModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemModule record, @Param("example") SystemModuleExample example);

    int updateByExample(@Param("record") SystemModule record, @Param("example") SystemModuleExample example);

    int updateByPrimaryKeySelective(SystemModule record);

    int updateByPrimaryKey(SystemModule record);
}