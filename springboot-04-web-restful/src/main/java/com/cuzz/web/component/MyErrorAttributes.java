package com.cuzz.web.component;

import java.util.Map;

/**
 * Created by Administrator on 2018/12/28.
 */

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回的map就是页面和json获取的所有字段
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace ){
        Map<String, Object> map = super(requestAttributes,includeStackTrace );
        map.put("name", "zzz");

        //我们的异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>）requestAttributes.getAttribute("ext",0);
        map.put("ext",ext);
        return map;

    }
}
