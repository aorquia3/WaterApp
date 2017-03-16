package com.two_six_mafia.root.waterapp.Model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Aaron on 3/16/2017.
 */

public class PurityReport {

    private static int REPORT_COUNTER;

    private int reportNumber;
    private String date;
    private String time;
    private String reporter;
    private OverallCondition overallCondition;
    private double virusPPM;
    private double contaminantPPM;
    private LatLng location;

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
