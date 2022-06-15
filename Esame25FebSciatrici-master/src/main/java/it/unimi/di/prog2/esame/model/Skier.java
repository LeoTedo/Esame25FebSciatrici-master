package it.unimi.di.prog2.esame.model;

import org.jetbrains.annotations.NotNull;

public class Skier {

    private String name;
    private double time;

    public Skier(@NotNull String name, @NotNull double time) {
        this.name = name;
        this.time = time;
    }

//public Skier addTime(double t){
       // return new Skier(name, t);
//}

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }
}
