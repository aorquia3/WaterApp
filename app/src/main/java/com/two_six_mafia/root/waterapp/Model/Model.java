package com.two_six_mafia.root.waterapp.Model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aaron on 2/23/17.
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

    private Model() {
        currentUser = null;
        sourceList = new ArrayList<>();
        reportList = new ArrayList<>();
    }

    public void setCurrentUser(Person person) {
        this.currentUser = person;
    }

    public Person getCurrentUser() {
        return currentUser;
    }

    public void addToReports(SourceReport sourceReport) {
        reportList.add(sourceReport);
    }

    public void addToSources(WaterSource source) {
        sourceList.add(source);
    }

    public ArrayList<WaterSource> getSourceList() {
        return sourceList;
    }

    public ArrayList<SourceReport> getReportList() {
        return reportList;
    }

}
