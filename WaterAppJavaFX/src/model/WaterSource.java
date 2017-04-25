package model;

import java.time.LocalDateTime;
import java.io.Serializable;


/**
 * Created by TriciaPSRosario on 4/9/17.
 */
public class WaterSource implements Serializable{
    private double lat;
    private double lon;
    private int sourceNumber;
    private static int SOURCE_COUNTER;
    private LocalDateTime dateTime;
    private Person reporter;
    private WaterType waterType;
    private WaterCondition waterCondition;


    /**
     * Default Constructor
     */
    public WaterSource() {
    }

    /**
     *
     * @param waterType what type of water source the source is
     * @param waterCondition what condition the water source is in
     * @param lat latitude of the source
     * @param lon longitude of the source
     */
    public WaterSource(WaterType waterType, WaterCondition waterCondition, double lat, double lon) {
        this.waterType = waterType;
        this.waterCondition = waterCondition;
        this.lat = lat;
        this.lon = lon;
        this.reporter = Model.getInstance().getCurrentUser();
        this.sourceNumber = ++SOURCE_COUNTER;
        this.dateTime = LocalDateTime.now();
    }

    /**
     * Sets the UserType
     * @param waterType that determines user privileges
     */
    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    /**
     * Sets the UserType
     * @param waterCondition that determines user privileges
     */
    public void setWaterCondition(WaterCondition waterCondition) {
        this.waterCondition = waterCondition;
    }

    /**
     * Returns location
     * @return int location
     */
    public Location getLocation() { return new Location(lat,lon); }

    public Double getLat() { return lat; }

    public Double getLon() { return lon; }

    public WaterType getWaterType() {
        return waterType;
    }

    public WaterCondition getWaterCondition() { return waterCondition; }

    public LocalDateTime getDT() {
        return dateTime;
    }

    public String getReporter() { return reporter.getUsername(); }

    public int getSourceNumber() {
        return sourceNumber;
    }

    /**
     * ToString for the water source (just a location)
     * @return a string of the location and water source
     */
    public String toString() {
        return "Report number: " + getSourceNumber() + ","
                + " submitted on: " + getDT() + ","
                + " by: " + getReporter() + ", "
                + getLocation();
    }
}
