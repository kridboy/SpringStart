package com.keisse.springdemo.configwithannot;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.configwithannot.impl.TennisCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        HelloSpringApp app = new HelloSpringApp();
        app.run();
    }

    public void run() {
        //init with xml file
//        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotApplicationContext.xml")) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class)) {
            //retrieve bean, specify Coach interface explicitly to not get ClassCastException under any circumstance
            Coach theFirstCoach = context.getBean("myAnnotCoach", Coach.class);
            Coach theSecondCoach = context.getBean("swimCoach", Coach.class);//note first letter not capitalized.

            callbasicCoachMethods(theFirstCoach);
            callbasicCoachMethods(theSecondCoach);
            String str = ((TennisCoach)theFirstCoach).getEmail() + " " + ((TennisCoach)theFirstCoach).getTeam();
            System.out.println("the data: "+ str);

        }
    }

    void callbasicCoachMethods(Coach coach) {
        System.out.println("calling methods for: " + coach);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println();
    }

}
