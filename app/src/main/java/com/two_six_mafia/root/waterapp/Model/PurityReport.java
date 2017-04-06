package com.two_six_mafia.root.waterapp.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Aaron on 3/16/2017.
 */

public class PurityReport {

    private static int REPORT_COUNTER;

    private double lat;
    private double lon;
    private final int reportNumber;
    private final String date;
    private final String time;
    private final String reporter;
    private final OverallCondition overallCondition;
    private final double virusPPM;
    private final double contaminantPPM;


    /**
     * Creates the purity report
     * @param date of the report
     * @param time of the report
     * @param reporter name of the person who reports it
     * @param overallCondition the overall condition of the source
     * @param virusPPM virus parts per million
     * @param contaminantPPM contaminant per million
     * @param location location of water source
     */
    public PurityReport(String date, String time, String reporter, OverallCondition overallCondition,
                        double virusPPM, double contaminantPPM, LatLng location) {
        this.date = date;
        this.time = time;
        this.reporter = reporter;
        this.overallCondition =overallCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        this.lat = location.latitude;
        this.lon = location.longitude;
        this.reportNumber = ++REPORT_COUNTER;
    }

    public LatLng getLocation() {
        return new LatLng(lat,lon);
    }

    public double getVirusPPM() {
        return virusPPM;
    }

    public double getContaminantPPM() {
        return contaminantPPM;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    @Override
    public String toString() {
        return "Purity Report " + reportNumber + " Submitted by: " + reporter + " on " + date + " at "
                + time + ". Virus PPM: " + virusPPM + " Contaminant PPM: " + contaminantPPM + ".";
    }

    public String getReporter() {
        return reporter;
    }

    public OverallCondition getOverallCondition() {
        return overallCondition;
    }
}
