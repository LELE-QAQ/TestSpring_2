package test.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class Book {
    @Before("execution(* test.spring.aop.User.*(..))")
    public void before()
    {
        System.out.println("before...");
    }
    @AfterReturning("execution(* test.spring.aop.User.*(..))")
    public void  afterReturn()
    {
        System.out.println("after return...");
    }
    @After("execution(* test.spring.aop.User.*(..))")
    public void after()
    {
        System.out.println("after...");
    }
    @Around("execution(* test.spring.aop.User.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint)
    {
        System.out.println("方法之前...");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("方法之后....");
    }
}
