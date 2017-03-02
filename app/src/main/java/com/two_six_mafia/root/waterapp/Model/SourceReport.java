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

    /**
     * Constructs the source report
     * @param date report is submitted
     * @param time report is submiteed
     * @param reporter that submits report
     * @param waterType of the source
     * @param waterCondition of the source
     */
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

    /**
     * To string method
     * @return a string
     */
    public String toString() {
        return "Report number: " + reportNumber + " submitted on: " + date + " " + time + " By: " + reporter;
    }
}
