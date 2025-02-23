package com.demik.aopdemo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic";
    }

    @Override
    public String getFortune(boolean b) {

        if (b) {
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        return getFortune();
    }
}
