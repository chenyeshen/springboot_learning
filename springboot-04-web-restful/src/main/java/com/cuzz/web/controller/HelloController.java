package com.cuzz.web.controller;

import com.cuzz.web.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author: cuzz
 * @Date: 2018/9/21 13:48
 * @Description:
 */
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping(value="hello")
    public String hello(@RequestParam("/user")String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    //查出一些数据在页面显示，把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
