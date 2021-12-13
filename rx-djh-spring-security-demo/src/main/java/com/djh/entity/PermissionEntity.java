package com.djh.entity;

import lombok.Data;

/**
 * @author: dujunhua
 * @create: 2021/10/25 22:55
 * @description: 权限表
 */
@Data
public class PermissionEntity {
    private Integer id;
    /**
     * 权限名称
     */
    private String permName;
    /**
     * 权限标识
     */
    private String permTag;
    /**
     * 请求url
     */
    private String url;
}
