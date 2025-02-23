package com.demik.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {

    @After("execution(* com.demik.aopdemo.dao.AccountDAOImpl.findAccounts(..))")
    public void afterNegroAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();

        System.out.println("After advice: " + method);
    }

}
