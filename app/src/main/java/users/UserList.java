package users;

import java.util.HashMap;

/**
 * Created by aaron on 2/22/17.
 */

public class UserList {
    private HashMap<String, Person> users;

    public UserList(Person person) {
        users = new HashMap<String, Person>();
        users.put(person.getUsername(), person);
    }

    public boolean isRegisteredUser(String username) {
        return users.containsKey(username);
    }
}
