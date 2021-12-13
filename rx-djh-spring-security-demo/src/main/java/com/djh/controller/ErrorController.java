package com.djh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dujunhua
 * @create: 2021/10/25 17:20
 * @description:
 */
@RestController
public class ErrorController {
    @RequestMapping("/error/403")
    public String error() {
        return "您当前访问的接口权限不足!";
    }
}