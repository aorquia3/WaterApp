package com.two_six_mafia.root.waterapp.Model;

import java.util.Stack;

/**
 * Created by aaron on 3/1/17.
 * Represents a location on the map which can contain multiple reports.
 */

public class WaterSource {
    private int location;
    private Stack<SourceReport> sourceReports;

    public WaterSource(SourceReport sourceReport) {
        sourceReports = new Stack<>();
        sourceReports.push(sourceReport);
    }

    public Stack<SourceReport> getSourceReports() {
        return sourceReports;
    }

    public void addSourceReport(SourceReport sourceReport) {
        sourceReports.push(sourceReport);
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String toString() {
        return "Water Source at: " + location;
    }
}