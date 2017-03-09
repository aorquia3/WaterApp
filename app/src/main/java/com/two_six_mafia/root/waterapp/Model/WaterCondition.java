package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by aaron on 3/2/17.
 */

/**
 * Holds the Options for Water Conditions
 */
public enum WaterCondition {
    WASTE("Waste"), TREATABLECLEAR("Treatable Clear"), TREATABLEMUDDY("Treatable Muddy"), POTABLE("Potable");
    private String name;

    WaterCondition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
