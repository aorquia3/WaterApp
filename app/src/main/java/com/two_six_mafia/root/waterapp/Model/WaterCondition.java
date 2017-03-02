package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by aaron on 3/2/17.
 */

/**
 * Holds the Options for Water Conditions
 */
public enum WaterCondition {
    WASTE("Waste"), TREATABLECLEAR("Treatable Clear"), TREATABLEMUDDY("Treatable Muddy"), POTABLE("Potable");
    private String rep;

    WaterCondition(String rep) {
        this.rep = rep;
    }

    @Override
    public String toString() {
        return rep;
    }
}
