package com.two_six_mafia.root.waterapp.Model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;

/**
 * Created by aaron on 2/22/17.
 * Keeps a constant list of registered users for the app. (Singleton)
 */

public class UserList {
    private static final UserList userList = new UserList();
    private final HashMap<String, Person> users;

    /**
     * Returns the user list for the application
     * @return UserList
     */
    public static UserList getInstance() {
        return userList;
    }

    /**
     * Default constructor.
     */
    private UserList() {
        users = new HashMap<>();
    }

    /**
     * Adds user to the userlist
     * @param person to be added
     */
    public void addUser(Person person) {
        users.put(person.getUsername(), person);
    }

    /**
     * Returns a user object by their string username
     * @param username in string form
     * @return Person the user with given username
     */
    public Person getUser(String username) {
        return users.get(username);
    }

    /**
     * Checks if a user is registered by username
     * @param username string username to look up
     * @return boolean whether user exists in the system.
     */
    public boolean isRegisteredUser(String username) {
        return users.containsKey(username);
    }
}
