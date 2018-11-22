package com.xiaojian.config;

import com.xiaojian.bean.Person;
import com.xiaojian.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration //告诉Spring这是一个配置类
@ComponentScan(value = "com.xiaojian",includeFilters = {
//        @Filter(type= FilterType.ANNOTATION,classes = {Controller.class}),
//        @Filter(type= FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @Filter(type= FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)
public class MainConfig {

    //给容器增加一个bean；类型为返回值的类型；id是方法名
    @Bean("person01")
    public Person person(){
        return new Person("lisi",20);
    }
}
