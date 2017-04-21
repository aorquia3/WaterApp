package model;

import java.time.LocalDateTime;

/**
 * Created by TriciaPSRosario on 4/13/17.
 */
public class PurityReport {
    private static int REPORT_COUNTER;

    private double lat;
    private double lon;
    private int reportNumber;
    private Person reporter;
    private OverallCondition overallCondition;
    private String virusPPM;
    private String contaminantPPM;
    private LocalDateTime dateTime;

    public PurityReport() {
    }

    /**
     * Creates the purity report
     * @param overallCondition the overall condition of the source
     * @param virusPPM virus parts per million
     * @param contaminantPPM contaminant per million
     * @param lat latitude of the source
     * @param lon longitude of the source
     */
    public PurityReport(OverallCondition overallCondition, String virusPPM, String contaminantPPM, double lat, double lon) {
        this.overallCondition =overallCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        this.lat = lat;
        this.lon = lon;
        Model model = Model.getInstance();
        this.reporter = model.getCurrentUser();
        this.reportNumber = ++REPORT_COUNTER;
        this.dateTime = LocalDateTime.now();
    }

    public void setCondition(OverallCondition overallCondition) {
        this.overallCondition = overallCondition;
    }

    public Location getLocation() { return new Location(lat,lon); }

    public Double getLat() { return lat; }

    public Double getLon() { return lon; }

    public String getVirusPPM() {
        return virusPPM;
    }

    public String getContaminantPPM() {
        return contaminantPPM;
    }

    public LocalDateTime getDT() {
        return dateTime;
    }

    public OverallCondition getOverallCondition() {
        return overallCondition;
    }

    public String getReporter() { return reporter.getUsername(); }

    public int getReportNumber() {
        return reportNumber;
    }

    @Override
    public String toString() {
        return "Report number: " + getReportNumber() + ","
                + " submitted on " + getDT() + ","
                + " by: " + getReporter() + ","
                + " at: " + getLocation()
                + ". Virus (in PPM): " + getVirusPPM() + ","
                + " contaminant (in PPM): " + getContaminantPPM() + ","
                + " overall condition: " + getOverallCondition() + ".";
    }
}
