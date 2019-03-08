package test.spring.transaction.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.account();
    }
}
