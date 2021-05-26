package com.keisse.springdemo.configwithannot.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


//@Component("myAnnotCoach")
    public class TennisCoach implements Coach {
    FortuneService fortuneService;
    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    @Autowired
    public TennisCoach(@Qualifier("realFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Swing that racket real hard";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @PostConstruct
    private void init(){
        System.out.println("initializing object");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Destroying object");
    }
}
