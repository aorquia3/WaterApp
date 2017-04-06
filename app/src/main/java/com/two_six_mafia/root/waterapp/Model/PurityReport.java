package com.two_six_mafia.root.waterapp.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Aaron on 3/16/2017.
 */

public class PurityReport {

    private static int REPORT_COUNTER;

    private final int reportNumber;
    private final String date;
    private final String time;
    private final String reporter;
    private final OverallCondition overallCondition;
    private final double virusPPM;
    private final double contaminantPPM;
    private final LatLng location;

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
        this.location = location;
        this.reportNumber = ++REPORT_COUNTER;
    }



    @Override
    public String toString() {
        return "Purity Report " + reportNumber + " Submitted by: " + reporter + " on " + date + " at "
                + time + ". Virus PPM: " + virusPPM + " Contaminant PPM: " + contaminantPPM + ".";
    }
}
