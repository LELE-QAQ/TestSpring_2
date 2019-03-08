import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test.spring.aop.User;

public class TestAOP {
    @Test
    public void fun1()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        User user = (User) applicationContext.getBean("user");
        user.test();
    }
}
