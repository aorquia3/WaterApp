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
    private String date;
    private String time;
    private String reporter;
    private WaterType waterType;
    private WaterCondition waterCondition;

    public SourceReport(String date, String time, String reporter, WaterType waterType, WaterCondition waterCondition) {
        this.date = date;
        this.time = time;
        this.reporter = reporter;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.reportNumber = REPORT_COUNTER++;
    }

    /**
     * Will get the location
     * @return location of parent
     */
    public int getLocation() {
        return parent.getLocation();
    }

    public String toString() {
        return "Report number: " + reportNumber + " Submitted on: " + date + " " + time + " By: " + reporter;
    }
}
