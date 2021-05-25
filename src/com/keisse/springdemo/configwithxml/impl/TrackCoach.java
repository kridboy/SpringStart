package com.keisse.springdemo.configwithxml.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;


    public TrackCoach() {
    }

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a few miles, nigga";
    }

    @Override
    public String getDailyFortune() {
        return "Wanna know whatI think? " + fortuneService.getFortune();
    }
}
