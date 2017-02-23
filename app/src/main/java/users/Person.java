package users;

/**
 * Created by aaron on 2/22/17.
 */

public class Person {
    private String username;
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
     * @param name of the Person
     * @param userType being admin, user, manager, or worker
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

    /**
     * gets the name
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name of user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets USername
     * @param username of the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets Password
     * @param password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the UserType
     * @param userType that determines user privileges
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
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

    /**
     * toString Methode
     * @return a string
     */
    public String toString() {
        return null;
    }
}
