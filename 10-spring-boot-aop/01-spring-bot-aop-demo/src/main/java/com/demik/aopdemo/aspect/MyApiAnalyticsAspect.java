package com.demik.aopdemo.aspect;

import com.demik.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-71)
public class MyApiAnalyticsAspect {

    @Before("com.demik.aopdemo.aspect.DemikExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account account) {

                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }

        System.out.println("\n=====>>> Performing n-word analytics");
    }
}
