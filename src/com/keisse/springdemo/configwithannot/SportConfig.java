package com.keisse.springdemo.configwithannot;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.FortuneService;
import com.keisse.springdemo.configwithannot.impl.RealFortuneService;
import com.keisse.springdemo.configwithannot.impl.SwimCoach;
import com.keisse.springdemo.configwithannot.impl.TennisCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:resources/sport.properties")
//componentscan performs initialisation for us automatically
//@ComponentScan("com.keisse.springdemo.configwithannot")
public class SportConfig {
    @Bean
    public FortuneService realFortuneService(){
        return new RealFortuneService();
    }
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
    @Bean
    public Coach myAnnotCoach(){
        //inject realfortuneservice bean(dependency) in init
        return new TennisCoach(realFortuneService());
    }
}
