package com.two_six_mafia.root.waterapp.Model;

/**
 * Created by aaron on 2/22/17.
 */

/**
 * Holds the types of Users
 */
public enum UserType {
    USER("User"), WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");
    private final String name;

    UserType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
