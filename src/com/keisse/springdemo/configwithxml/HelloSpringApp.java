package com.keisse.springdemo.configwithxml;

import com.keisse.springdemo.Coach;
import com.keisse.springdemo.configwithxml.impl.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        HelloSpringApp app = new HelloSpringApp();
        app.run();
    }

    void run(){
        //load spring config
        //autocloseable context, call try with resources
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");){
            //retrieve bean, specify Coach interface explicitly to not get ClassCastException under any circumstance
            Coach theFirstCoach = context.getBean("myCoach",Coach.class);
            Coach theSecondCoach = context.getBean("myCoach",Coach.class);

            Coach theOtherCoach = context.getBean("myOtherCoach",Coach.class);
            Coach anotherCoach = context.getBean("myOtherCoach", Coach.class);

            displayCricketCoachInfo(theOtherCoach);

            System.out.println("\nBaseballCoach Bean comparison");
            confirmSameObjects(theFirstCoach,theSecondCoach);
            System.out.println("\nCricketCoach Bean comparison");
            confirmSameObjects(theOtherCoach,anotherCoach);
        }

    }


    void confirmSameObjects(Coach coach1, Coach coach2){
        //Since scope of beans was set to "prototype", comparing them should yield false result
        System.out.println("references point to same object? " + (coach1 == coach2));
    }

    void displayCricketCoachInfo(Coach coach){
        //call methods on bean
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println("EMAIL: "+((CricketCoach)coach).getEmail());
        System.out.println("TEAM: "+((CricketCoach)coach).getTeam());
    }
}
