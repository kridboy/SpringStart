package com.keisse.springdemo.configwithannot;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.configwithannot.impl.TennisCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        HelloSpringApp app = new HelloSpringApp();
        app.run();
    }

    public void run() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotApplicationContext.xml");) {
            //retrieve bean, specify Coach interface explicitly to not get ClassCastException under any circumstance
            Coach theFirstCoach = context.getBean("myAnnotCoach", Coach.class);
            Coach theSecondCoach = context.getBean("swimCoach", Coach.class);//note first letter not capitalized.


            System.out.println(theFirstCoach.getDailyWorkout());
            System.out.println(theSecondCoach.getDailyWorkout());
            System.out.println(theFirstCoach.getDailyFortune());// zonder downcasting??
        }
    }

}
