package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by Aaron on 3/16/2017.
 */

public enum OverallCondition {
    SAFE("Safe"), TREATABLE("Treatable"), UNSAFE("Unsafe");
    private String name;

    OverallCondition(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
