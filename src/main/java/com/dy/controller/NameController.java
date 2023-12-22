package com.dy.controller;

import com.dy.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dy
 * @Date: 2023/12/21 17:17
 * @Description: 获取姓名接口
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping
    public String getName(@RequestParam String name) {
        System.out.println("get 你的名字为: " + name);
        return "get 你的名字为: " + name;
    }

    @PostMapping
    public String postName(@RequestParam String name) {
        System.out.println("post 你的名字为: " + name);
        return "post 你的名字为: " + name;
    }

    @PostMapping("/json")
    public String postJsonName(@RequestBody User user) {
        System.out.println("json post 你的名字为: " + user.getName());
        return "json post 你的名字为: " + user.getName();
    }



}
