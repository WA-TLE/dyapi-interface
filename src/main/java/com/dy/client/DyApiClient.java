package com.dy.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.dy.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * @Author: dy
 * @Date: 2023/12/21 17:35
 * @Description:
 */
public class DyApiClient {

    public String getName(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "dy");

        String result = HttpUtil.get("http://localhost:8081/api/name", paramMap);
        System.out.println(result);
        return result;
    }

    public String postName(@RequestParam String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", "dy");

        String result = HttpUtil.post("http://localhost:8081/api/name", paramMap);
        System.out.println(result);
        return result;
    }

    public String postJsonName(User user) {
        String json = JSONUtil.toJsonStr(user);

        HttpResponse httpResponse = HttpRequest.post("http://localhost:8081/api/name/json")
                .body(json)
                .execute();

        System.out.println(httpResponse.getStatus());

        String result = httpResponse.body();
        System.out.println(result);

        return "json post 你的名字为: " + result;
    }


}
