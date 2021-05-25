package com.keisse.springdemo.configwithxml.impl;

import com.keisse.springdemo.FortuneService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class RealFortuneService implements FortuneService {
    private List<String> fortunes;

    public RealFortuneService() {
        try{
            fortunes = Files.readAllLines(Path.of(new File("src/resources/fortunes.txt").toURI()));
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        Random r = new Random();
        return fortunes.get(r.nextInt(6));
    }
}
