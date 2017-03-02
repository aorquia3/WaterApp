package com.two_six_mafia.root.waterapp.Model;
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

    private LinkedList<WaterSource> sourceList;

    //We want to track the user who is currently logged in.
    private Person currentUser;

    private Model() {
        currentUser = null;
    }

    public void setCurrentUser(Person person) {
        this.currentUser = person;
    }

    public Person getCurrentUser() {
        return currentUser;
    }

    public void addToSources(WaterSource source) {
        sourceList.add(source);
    }

    public List<WaterSource> getSourceList() {
        return sourceList;
    }

}
