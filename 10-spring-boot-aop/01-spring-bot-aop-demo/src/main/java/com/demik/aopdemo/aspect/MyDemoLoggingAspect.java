package com.demik.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(23)
public class MyDemoLoggingAspect {
    //    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.demik.aopdemo.dao.AccountDAOImpl.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(void add*())")
//    @Before("execution(* add*(com.demik.aopdemo.Account, ..))")
    @Before("com.demik.aopdemo.aspect.DemikExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("ez znigeginaiegneingiea");
    }

}
