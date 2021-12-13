package com.djh.mapper;

import com.djh.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: dujunhua
 * @create: 2021/10/25 22:56
 * @description:
 */
@Mapper
public interface PermissionMapper {

    /**
     * 查询所有权限
     *
     * @return
     */
    @Select(" select * from sys_permission ")
    List<PermissionEntity> findAllPermission();

}
