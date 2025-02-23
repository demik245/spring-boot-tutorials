package com.demik.aopdemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAdvice {

    @AfterThrowing(
            pointcut = "execution(* com.demik.aopdemo.dao.AccountDAOImpl.findAccounts(..))",
            throwing = "ex"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable ex) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("Method: " + method);


        System.out.println("=====>>> exception: " + ex);
    }
}
