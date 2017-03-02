package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by aaron on 3/1/17.
 * Used with the Water Source class to track initial water reports.
 */

public class SourceReport {

    //Keep track of the water source that this report belongs to.
    private WaterSource parent;
    //Count the total number of reports
    private static int REPORT_COUNTER;

    private int reportNumber;
    private int date;
    private String reporter;
    private WaterType waterType;
    private WaterCondition waterCondition;


    public int getLocation() {
        return parent.getLocation();
    }
}
