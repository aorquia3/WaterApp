package com.two_six_mafia.root.waterapp.Model;

import com.google.android.gms.maps.model.LatLng;



/**
 * Created by aaron on 3/1/17.
 * Represents a location on the map which can contain multiple reports.
 */

public class WaterSource {
    //Location currently stored as an int representing LATLONG, this is likely to change in the future.
    private LatLng location;
    //Sorting reports in a stack should naturally order them with time.
    private SourceReport sourceReport;
    private static int SOURCE_COUNTER;
    private int sourceNumber;

    /**
     * Default constructor
     * @param sourceReport first sourceReport for a given WaterSource
     */
    public WaterSource(SourceReport sourceReport) {
        this.sourceReport = sourceReport;
        sourceNumber = ++SOURCE_COUNTER;
    }

    /**
     * Return the water source's list of reports
     * @return Stack of sourceReports
     */
    public SourceReport getSourceReport() {
        return sourceReport;
    }

    /**
     * Add a purity report to the water source.
     * @param purityReport that will be used
     */
    public void addPurityReport(PurityReport purityReport) {
    }

    /**
     * Set location as an int, needs to be changed upon map integration
     * @param location of the source
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

    public int getSourceNumber() {
        return sourceNumber;
    }

    /**
     * ToString for the water source (just a location)
     * @return a string of the location and water source
     */
    public String toString() {
        return "Water Source at: " + location;
    }
}
