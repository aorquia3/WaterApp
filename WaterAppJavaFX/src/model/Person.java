package model;

/**
 * Created by TriciaPSRosario on 3/28/17.
 */
public class Person {
    private String username;
    private String password;
    private String name;
    private String email;
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
     * @param name display name
     * @param email email address
     * @param userType type of user (ENUM)
     */
    public Person(String username, String password, String name, String email, UserType userType) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
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
     * Gets the Username
     * @return a string of the username
     */
    public String getPassword() {
        return password;
    }

    /**
     * gets the name
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the type of user.
     * @return userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Returns a user's email address
     * @return
     */
    public String getEmail() {
        return email;
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
     * Allows users to change their email address
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
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
     * toString Method
     * @return a string
     */
    public String toString() {
        return name + " with username: " + username;
    }
}
