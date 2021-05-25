package com.keisse.springdemo.configwithannot.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//When specifying no name, a default name will be used. It can be called with Classname, with first letter not capitalized
@Scope("prototype")
@Component
public class SwimCoach implements Coach {
    FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Swim 10km";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
