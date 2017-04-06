package com.two_six_mafia.root.waterapp.Model;
import java.util.ArrayList;

/**
 * Overarching model class
 */
public class Model {
    //Set up the singleton to contain data used by the entire app.
    private static final Model ourInstance = new Model();

    /**
     * Constructs our model.
     */
    private Model() {
        currentUser = null;
        sourceList = new ArrayList<>();
        reportList = new ArrayList<>();
        purityReports = new ArrayList<>();
    }

    /**
     * Allows us to access our instance of the model.
     * @return Model
     */
    public static Model getInstance() {
        return ourInstance;
    }

    //Store the list of sources,
    private final ArrayList<WaterSource> sourceList;
    private final ArrayList<SourceReport> reportList;
    private final ArrayList<PurityReport> purityReports;

    //Store the user who is currently logged in to determine access levels.
    private Person currentUser;

    /**
     * sets up the current user
     * @param person type
     */
    public void setCurrentUser(Person person) {
        this.currentUser = person;
    }

    /**
     * Get's current user
     * @return current user
     */
    public Person getCurrentUser() {
        return currentUser;
    }

    /**
     * Add to the Source Report
     * @param sourceReport that's being submitted
     */
    public void addToReports(SourceReport sourceReport) {
        reportList.add(sourceReport);
    }

    /**?
     * Adds to Sources
     * @param source thats being submitted
     */
    public void addToSources(WaterSource source) {
        sourceList.add(source);
    }

    /**
     * Adds a purity report to the list of reports
     * @param purityReport that will be looked at
     */
    public void addToPurityReports(PurityReport purityReport) {
        purityReports.add(purityReport);
    }

    /**
     * Returns a list of the purity reports
     * @return purityReports;
     */
    public ArrayList<PurityReport> getPurityReports() {
        return purityReports;
    }

    /**
     * Gets the Source List
     * @return sourceList
     */
    public ArrayList<WaterSource> getSourceList() {
        return sourceList;
    }

    /**
     * Gets the Report List
     * @return reportList
     */
    public ArrayList<SourceReport> getReportList() {
        return reportList;
    }

    /**
     * Removes the current user and sets it to null.
     */
    public void removeCurrentUser() {
        currentUser = null;
    }

}
