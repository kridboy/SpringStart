package com.keisse.springdemo.configwithannot.impl;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//When specifying no name, a default name will be used. It can be called with Classname, with first letter not capitalized
@Scope("prototype")
//@component annotation can be omitted when creating beans yourself
//@Component
public class SwimCoach implements Coach {
    //immediate field injection
    @Qualifier("realFortuneService")
    @Autowired
    FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Swim 10km";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //setter injection
//    @Autowired
//    public void setFortuneService(@Qualifier("realFortuneService") FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    //method injection
//    @Autowired
//    public void injectVarInMethod(@Qualifier("realFortuneService") FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//        System.out.println("filled with method inject!");
//    }

}
