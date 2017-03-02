package com.two_six_mafia.root.waterapp.Model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aaron on 2/23/17.
 */

/**
 * Overarhing model class
 */
public class Model {
    private static Model ourInstance = new Model();
    public static Model getInstance() {
        return ourInstance;
    }

    private ArrayList<WaterSource> sourceList;
    private ArrayList<SourceReport> reportList;

    //We want to track the user who is currently logged in.
    private Person currentUser;

    /**
     * Constructs the model
     */
    private Model() {
        currentUser = null;
        sourceList = new ArrayList<>();
        reportList = new ArrayList<>();
    }

    /**
     * sets up the current user
     * @param person
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

}
