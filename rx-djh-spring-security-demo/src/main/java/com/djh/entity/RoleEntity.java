package com.djh.entity;

import lombok.Data;

/**
 * @author: dujunhua
 * @create: 2021/10/25 22:55
 * @description: 角色表
 */
@Data
public class RoleEntity {

    private Integer id;

    private String roleName;

    private String roleDesc;
}
