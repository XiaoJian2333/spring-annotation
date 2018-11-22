package com.xiaojian.test;

import com.xiaojian.bean.Blue;
import com.xiaojian.bean.Person;
import com.xiaojian.config.MainConfig;
import com.xiaojian.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){

        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean1 = applicationContext.getBean("colorFactoryBean");
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型："+bean1.getClass());
        System.out.println(bean1==bean2);
        Object bean3 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean3.getClass());

    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name:names){
            System.out.println(name);
        }
    }


    @Test
    public void test03(){
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name:namesForType){
            System.out.println(name);
        }
        Map<String, Person> porsons = applicationContext.getBeansOfType(Person.class);
        System.out.println(porsons);
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:definitionNames){
            System.out.println(name);
        }

        System.out.println("容器创建完成。。。");
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person==person2);

    }

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:definitionNames){
            System.out.println(name);
        }

    }
}
