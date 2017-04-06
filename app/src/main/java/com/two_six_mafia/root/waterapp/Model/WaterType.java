package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by aaron on 3/2/17.
 */

/**
 * Holds the Types of Water 
 */
public enum WaterType {
    BOTTLED("Bottled"), WELL("Well"), STREAM("Stream"), LAKE("Lake"), SPRING("Spring"), OTHER("Other");

    private final String name;

    WaterType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
