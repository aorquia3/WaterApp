package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by aaron on 2/23/17.
 */
public class Model {
    private static Model ourInstance = new Model();
    public static Model getInstance() {
        return ourInstance;
    }

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
}
