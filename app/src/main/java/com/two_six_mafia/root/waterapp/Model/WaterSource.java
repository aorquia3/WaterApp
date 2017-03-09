package com.two_six_mafia.root.waterapp.Model;

import com.google.android.gms.maps.model.LatLng;

import java.util.Stack;

/**
 * Created by aaron on 3/1/17.
 * Represents a location on the map which can contain multiple reports.
 */

public class WaterSource {
    //Location currently stored as an int representing LATLONG, this is likely to change in the future.
    private LatLng location;
    //Sorting reports in a stack should naturally order them with time.
    private Stack<SourceReport> sourceReports;

    /**
     * Default constructor
     * @param sourceReport first sourceReport for a given WaterSource
     */
    public WaterSource(SourceReport sourceReport) {
        sourceReports = new Stack<>();
        sourceReports.push(sourceReport);
    }

    /**
     * Return the water source's list of reports
     * @return Stack of sourceReports
     */
    public Stack<SourceReport> getSourceReports() {
        return sourceReports;
    }

    /**
     * Add a source report to the water source.
     * @param sourceReport
     */
    public void addSourceReport(SourceReport sourceReport) {
        sourceReports.push(sourceReport);
    }

    /**
     * Set location as an int, needs to be changed upon map integration
     * @param location
     */
    public void setLocation(LatLng location) {
        this.location = location;
    }

    /**
     * Returns location
     * @return int location
     */
    public LatLng getLocation() {
        return location;
    }

    /**
     * ToString for the water source (just a location)
     * @return
     */
    public String toString() {
        return "Water Source at: " + location;
    }
}
