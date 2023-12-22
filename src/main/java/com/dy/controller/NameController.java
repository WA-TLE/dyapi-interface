package com.dy.controller;

import cn.hutool.core.util.StrUtil;
import com.dy.model.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dy
 * @Date: 2023/12/21 17:17
 * @Description: 获取姓名接口
 */
@RestController
@RequestMapping("/name")
@Slf4j
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
    public String postJsonName(@RequestBody User user, HttpServletRequest request) {

        log.info("request: {}", request);

        //  1. 从请求头中获取 accessKey 和 secretKey 来判断是否为合法调用
        String accessKey = request.getHeader("accessKey");
        String secretKey = request.getHeader("secretKey");


        // TODO: 2023/12/22  这里应该是从数据库中取 accessKey 和 secretKey 的, 这里先不照做

        if (StrUtil.hasBlank(accessKey, secretKey)) {
            throw new RuntimeException("无权限!!");
        }

        if (!accessKey.equals("dingyu") || !secretKey.equals("Hello world")) {
            throw new RuntimeException("无权限!!");
        }

        //  2. 校验完成, 放行调用

        System.out.println("json post 你的名字为: " + user.getName());
        return "json post 你的名字为: " + user.getName();
    }



}
