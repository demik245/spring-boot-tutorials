package com.demik.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DemikExpressions {

    @Pointcut("execution(* com.demik.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.demik.aopdemo.dao.*.get*(..))")
    public void getter () {}

    @Pointcut("execution(* com.demik.aopdemo.dao.*.set*(..))")
    public void setter () {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter () {}

}
