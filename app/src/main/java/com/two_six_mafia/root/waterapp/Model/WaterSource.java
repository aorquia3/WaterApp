package com.two_six_mafia.root.waterapp.Model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;


/**
 * Created by aaron on 3/1/17.
 * Represents a location on the map which can contain multiple reports.
 */

public class WaterSource implements Serializable {
    //Location currently stored as an int representing LATLONG
    private double lat;
    private double lon;
    private final int sourceNumber;

    private static int SOURCE_COUNTER;

    private final String date;
    private final String time;
    private final String reporter;
    private final WaterType waterType;
    private final WaterCondition waterCondition;

    /**
     *
     * @param date
     * @param time
     * @param reporter
     * @param waterType
     * @param waterCondition
     * @param lat
     * @param lon
     */
    public WaterSource(String date, String time, String reporter, WaterType waterType, WaterCondition waterCondition, double lat, double lon) {
        this.date = date;
        this.time = time;
        this.reporter = reporter;
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.lat = lat;
        this.lon = lon;
        this.sourceNumber = ++SOURCE_COUNTER;
    }


    /**
     * Add a purity report to the water source.
     * @param purityReport that will be used
     */
    public void addPurityReport(PurityReport purityReport) {
    }

    /**
     * Set location as a lat/long
     * @param location of the source
     */
    public void setLocation(LatLng location) {
        this.lat = location.latitude;
        this.lon = location.longitude;
    }

    /**
     * Returns location
     * @return int location
     */
    public LatLng getLocation() {
        return new LatLng(lat,lon);
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getReporter() {
        return reporter;
    }

    public int getSourceNumber() {
        return sourceNumber;
    }

    /**
     * ToString for the water source (just a location)
     * @return a string of the location and water source
     */
    public String toString() {
        return "Water Source: " + sourceNumber + " Submitted on: " + date + " " + time + " By: " + reporter +" At: " + getLocation();
    }
}
