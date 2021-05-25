package com.keisse.springdemo.configwithxml.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;

public class BaseballCoach implements Coach {
    private final FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Throw a few balls, fool";
    }

    private void initMethod(){
        System.out.println("initializing object");
    }


    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
