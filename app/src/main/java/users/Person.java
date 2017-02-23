package users;

import java.util.HashMap;

/**
 * Created by aaron on 2/22/17.
 */

public class Person {
    private final String username;
    //For now, passowords are still stored in plain text.
    private String password;

    /**
     * Default Constructor
     */
    public Person() {
        this.username = null;
        this.password = null;
    }

    /**
     * Constructor
     * @param username to enter the application
     * @param password that belongs with the username
     */
    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the Username
     * @return a string of the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks Password at Login
     * @param input typed in.
     * @return true if the string matches password string
     */
    public boolean checkPassword(String input) {
        return input.equals(password);
    }

    /**
     * Updates Password
     * @param password the new password
     */
    public void updatePassword(String password) {
        this.password = password;
    }
}
