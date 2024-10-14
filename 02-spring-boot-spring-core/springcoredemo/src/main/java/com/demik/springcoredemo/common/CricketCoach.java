package com.demik.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Primary
//@Lazy
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    /*
    @PostConstruct
    public void init() {
        System.out.println("In init method: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("In destroy method: " + getClass().getSimpleName());
    }
     */

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
