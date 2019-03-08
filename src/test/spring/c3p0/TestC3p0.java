package test.spring.c3p0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestC3p0 {
    public static  void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }
}
