package com.keisse.springdemo.configwithannot.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("myAnnotCoach")
    public class TennisCoach implements Coach {
    FortuneService fortuneService;

    @Autowired
    public TennisCoach(@Qualifier("realFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swing that racket real hard";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    private void init(){
        System.out.println("initializing object");
    }

    private void destroy(){
        System.out.println("Destroying object");
    }
}
