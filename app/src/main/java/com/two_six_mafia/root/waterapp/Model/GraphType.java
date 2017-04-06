package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by rjara on 4/6/2017.
 */

import java.io.Serializable;

/**
 * Holds the different options of graphs that we can create.
 */
public enum GraphType implements Serializable {
    CONT("Contaminant"), VIRUS("Virus");

    private final String name;

    GraphType(String name) {this.name = name;}

    @Override
    public String toString() {
            return name;
        }
    }
