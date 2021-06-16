package com.uwjx.dbpool.mapper_db1;

import com.uwjx.dbpool.entity.DbPool;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DbPool1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DbPool record);

    int insertSelective(DbPool record);

    List<DbPool> query();

    int updateByPrimaryKeySelective(DbPool record);

    int updateByPrimaryKey(DbPool record);
}
