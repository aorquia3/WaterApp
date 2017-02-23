package users;

import java.util.HashMap;

/**
 * Created by aaron on 2/22/17.
 */

public class UserList {
    private static UserList userList = new UserList();
    private HashMap<String, Person> users = new HashMap<>();

    public static UserList getInstance() {
        return userList;
    }

    public void addUser(Person user) {
        users.put(user.getName(), user);
    }

    public boolean isRegisteredUser(String username) {
        return users.containsKey(username);
    }
}
