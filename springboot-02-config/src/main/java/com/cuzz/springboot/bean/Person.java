package com.cuzz.springboot.bean;

import com.cuzz.springboot.bean.Dog;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: cuzz
 * @Date: 2018/9/20 19:34
 * @Description:
 */
@PropertySource(value = {"classpath:person.properties"})
@Data
@Component
@Validated  //JSR303数据校验,配合下面@Email，@Value不支持
@ConfigurationProperties(prefix = "person")//将本类中所有属性和配置文件中相关的配置进行绑定
public class Person {

    /**
     * <bean class="Person">
     *      <property name="lastName" value="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}">
     *      </property>
     * <bean/>
     */

    //lastName必须是邮箱格式
    // @Email
    //@Value("${person.last-name}")
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;

    private Date birth;
    //@Value("${person.maps}")//这里用@Value无法取出maps里的值，不支持复杂类型
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

}
