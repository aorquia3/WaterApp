package users;

import java.util.HashMap;

/**
 * Created by aaron on 2/22/17.
 */

public class Person {
    private final String username;
    //For now, passowords are still stored in plain text.
    private String password;

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String input) {
        return input.equals(password);
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
