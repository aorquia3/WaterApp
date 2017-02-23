package users;

/**
 * Created by aaron on 2/22/17.
 */

public class Person {
    private final String username;
    //For now, passwords are still stored in plain text.
    private String password;
    private String name;
    private UserType userType;

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
     * @param
     */
    public Person(String username, String password, String name, UserType userType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.userType = userType;
    }

    /**
     * Gets the Username
     * @return a string of the username
     */
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
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

    public String toString() {
        return null;
    }
}
