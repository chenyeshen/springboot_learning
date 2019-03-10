package com.cuzz.springboot.controller;

import javax.xml.ws.RequestWrapper;

/**
 * Created by Administrator on 2018/12/27.
 */
public class HelloController {

    @Value(#{person.last-name})
    private String name;

    @RequestWrapper("/sayHallo")
    public String sayHelli(){
        return "hello"+name;
    }
}
