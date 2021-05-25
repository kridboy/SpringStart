package com.keisse.springdemo.configwithxml.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;

public class CricketCoach implements Coach {
    FortuneService fortuneService;
    private String email;
    private String team;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Ehhh, just do smth, dunno";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    private void destroyMethod(){
        System.out.println("destroying object");
    }
}
