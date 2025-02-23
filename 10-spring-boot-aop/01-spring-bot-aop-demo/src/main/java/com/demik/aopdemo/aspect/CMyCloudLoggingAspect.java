package com.demik.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(25)
public class CMyCloudLoggingAspect {
    @Before("com.demik.aopdemo.aspect.DemikExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("=====>>> logging: " + methodSignature);
    }
}
