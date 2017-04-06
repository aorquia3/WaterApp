package com.two_six_mafia.root.waterapp.Model;

import android.provider.ContactsContract;

import com.two_six_mafia.root.waterapp.Exceptions.EmailFormatException;
import com.two_six_mafia.root.waterapp.Exceptions.NameFormatException;
import com.two_six_mafia.root.waterapp.Exceptions.PasswordFormatException;
import com.two_six_mafia.root.waterapp.Exceptions.UsernameFormatException;

public class Person {
    private String username;
    //For now, passwords are still stored in plain text.
    private String password;
    private String name;
    private String email;
    private UserType userType;
    private int id;
    private static int USERNUMBER = 0;

    /**
     * Default Constructor
     */
    public Person() {
        id = ++USERNUMBER;
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
        id = ++USERNUMBER;
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
     * Returns the type of user.
     * @return userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Returns a user's email address
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the name
     * @param name of user
     */
    public void setName(String name) throws NameFormatException {
        if (name == null || name.equals("")) {
            throw new NameFormatException("Please enter your first and last name.");
        } else if (!name.contains(" ")) {
            throw new NameFormatException("First and last name must be separated by a space.");
        } else if (name.length() < 5) {
            throw new NameFormatException("Name must be at least five characters.");
        }

        this.name = name;
    }

    /**
     * Sets Username
     * @param username of the user
     */
    public void setUsername(String username) throws UsernameFormatException {
        UserList userList = UserList.getInstance();
        if (username.length() < 2) {
            throw new UsernameFormatException("Username must be at least two characters.");
        } else if (userList.isRegisteredUser(username)) {
            throw new UsernameFormatException("This username already exists in our system.");
        } else if (username.contains("fuck")) {
            throw new UsernameFormatException("Language!");
        }

        this.username = username;
    }

    /**
     * Sets Password
     * @param password of the user
     */
    public void setPassword(String password) throws PasswordFormatException {
        if (password.length() < 4) {
            throw new PasswordFormatException( "Password must be at least 4 characters.");
        } else if (password.equalsIgnoreCase(username)) {
            throw new PasswordFormatException("Don't use your username as your password.");
        }
        this.password = password;
    }

    /**
     * Allows users to change their email address
     * @param email the new email address
     */
    public void setEmail(String email) throws EmailFormatException {
        if (!email.contains("@") || !email.contains(".com")) {
            throw new EmailFormatException("Not a valid email address.");
        }

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

    public String getPassword() {
        return password;
    }

    /**
     * toString Method
     * @return a string
     */
    public String toString() {
        return name + " with username: " + username;
    }
}
