package com.cuzz.web.controller;

import com.cuzz.web.exception.UserNotExistException;

/**
 * Created by Administrator on 2018/12/28.
 */
@ControllerAdvice
public class MyExceptionHanler {

    //浏览器和客户端都返回json
//    @ExceptionHandler(UserNotExistException.class)
//    @ResponseBody
//    public Map<String, Object> ExceptionHandler(Exception e){
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("code", "user.notExit");
//        map.put("msg", e.getMessage());
//        return map;
//    }

    //用自适应方式：浏览器返回页面，客户端返回json
    @ExceptionHandler(UserNotExistException.class)
    public String ExceptionHandler(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", "user.notExit");
        map.put("msg", e.getMessage());
        //传入自己的状态码4xx/5xx,不传入就不会调用定制的错误页面解析流程
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("ext", map);
        //转发到/error，BaseErrorControler就会自适应处理
        return "forward:/error";
    }

}
