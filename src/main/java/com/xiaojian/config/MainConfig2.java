package com.xiaojian.config;

import com.xiaojian.bean.Color;
import com.xiaojian.bean.ColorFactoryBean;
import com.xiaojian.bean.Person;
import com.xiaojian.bean.Red;
import com.xiaojian.condition.LinuxCondition;
import com.xiaojian.condition.MyImportBeanDefinitionRegistrar;
import com.xiaojian.condition.MyImportSelector;
import com.xiaojian.condition.WindowsCondition;
import org.springframework.context.annotation.*;

//类中组件同一设置。满足当前条件，这个类中配置的所有bean注册才生效
//@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class,MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import导入组件，id默认是组件的全类名
public class MainConfig2 {

    //默认是单实例的

    /**
     *     ConfigurableBeanFactory#SCOPE_PROTOTYPE   prototype
     * 	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON  singleton
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST   request
     * 	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION   session
     * @return
     *
     * prototype：多实例的
     * singleton：单实例的（默认）
     * request：同一个请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     *      单实例bean：默认在容器启动的时候创建对象
     *      懒加载：容器启动不创建对象。第一次获取bean的时候才创建对象，并初始化
     *
     */
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加person。。。。");
        return new Person("张三",25);
    }

    /**
     * @Conditional({Condition}):按照一定的条件进行判断，满足条件给容器中添加bean
     *
     * 如果系统是windows,给容器中注册("bill")
     * 如果系统是linux,给容器中注册("linus")
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus",48);
    }

    /**
     * 给容器中注册组件；
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     * 		1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     * 		2）、ImportSelector:返回需要导入的组件的全类名数组；
     * 		3）、ImportBeanDefinitionRegistrar:手动注册bean到容器中
     * 4）、使用Spring提供的 FactoryBean（工厂Bean）;
     * 		1）、默认获取到的是工厂bean调用getObject创建的对象
     * 		2）、要获取工厂Bean本身，我们需要给id前面加一个&
     * 			&colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
