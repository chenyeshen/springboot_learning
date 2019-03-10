package com.cuzz.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

/**
 * Created by Administrator on 2018/12/27.
 */
public class HelloController {

    @Value("$(person.last-name)")
    private String name;

    @RequestMapping("/sayHallo")
    public String sayHelli(){
        return "hello"+name;
    }
}
