package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by rjara on 4/6/2017.
 */

/**
 * Holds the different options of graphs that we can create.
 */
public enum GraphType {
    CONT("Contaminant"), VIRUS("Virus");

    private final String name;

    GraphType(String name) {this.name = name;}

    @Override
    public String toString() {
            return name;
        }
    }
