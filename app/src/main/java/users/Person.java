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

    public Person() {
        this.username = null;
        this.password = null;
    }

    public Person(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String input) {
        return input.equals(password);
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public String toString()
}
