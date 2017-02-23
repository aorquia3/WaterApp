package users;

import java.util.HashMap;

/**
 * Created by aaron on 2/22/17.
 */

public class UserList {
    private static final UserList userList = new UserList();
    private HashMap<String, Person> users;

    public static UserList getInstance() {
        return userList;
    }

    private UserList() {
        users = new HashMap<String, Person>();
    }


    public void addUser(Person person) {
        users.put(person.getUsername(), person);
    }

    public Person getUser(String username) {
        return users.get(username);
    }

    public boolean isRegisteredUser(String username) {
        return users.containsKey(username);
    }
}
