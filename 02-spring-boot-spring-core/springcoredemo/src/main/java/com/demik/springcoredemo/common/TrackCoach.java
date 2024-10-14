package com.demik.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach  {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice 45 minutes of track running";
    }
}
