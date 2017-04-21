package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by TriciaPSRosario on 3/30/17.
 */
public class Model {
    private static Model ourInstance = new Model();
    public static Model getInstance() {
        return ourInstance;
    }

    private ArrayList<WaterSource> sourceList;
    private ArrayList<PurityReport> purityList;

    //We want to track the user who is currently logged in.
    private Person currentUser;

    /**
     * Constructs the model
     */
    private Model() {
        currentUser = null;
        sourceList = new ArrayList<>();
        purityList = new ArrayList<>();
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

    /**?
     * Adds to Sources
     * @param source that's being submitted
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

    /**?
     * Adds to Sources
     * @param source that's being submitted
     */
    public void addToPurityList(PurityReport source) { purityList.add(source); }

    /**
     * Gets the Source List
     * @return sourceList
     */
    public ArrayList<PurityReport> getPurityList() {
        return purityList;
    }

    public ArrayList<PurityReport> graphPurity(ArrayList<PurityReport> list, double lat, double lon, int year) {
        ArrayList<PurityReport> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).getDT().getYear() == year)
                    && (list.get(i).getLat() < lat + 0.5) && (list.get(i).getLat() > lat - 0.5)
                    && (list.get(i).getLon() < lon + 0.5) && (list.get(i).getLon() > lon - 0.5)) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}