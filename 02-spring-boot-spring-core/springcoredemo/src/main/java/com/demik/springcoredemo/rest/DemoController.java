package com.demik.springcoredemo.rest;

import com.demik.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
/*
    // define private field for the dependency
    private final Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
    public setCoach(Coach theCoach) {
        myCoach = theCoach;
    }
 */
//  private Coach anotherCoach;
    private Coach myCoach;


    @Autowired
    public void DemoController(@Qualifier("aquatic") Coach theCoach) {
        myCoach = theCoach;
        System.out.println("In constructor: " + getClass().getSimpleName());
    }


    @GetMapping("/dailyWorkout")
    String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    /*
    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
     */
}
