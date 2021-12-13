package com.djh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dujunhua
 * @create: 2021/10/25 17:24
 * @description: 用户页面
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 添加用户
     *
     * @return
     */
    @GetMapping("addUser")
    public String addUser() {
        return "addUser";
    }

    /**
     * 删除用户
     *
     * @return
     */
    @GetMapping("delUser")
    public String delUser() {
        return "delUser";
    }

    /**
     * 修改用户
     *
     * @return
     */
    @GetMapping("updUser")
    public String updUser() {
        return "updUser";
    }

    /**
     * 展示用户
     *
     * @return
     */
    @GetMapping("showUser")
    public String showUser() {
        return "showUser";
    }
}
