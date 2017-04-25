package model;

import java.util.HashMap;

/**
 * Created by TriciaPSRosario on 3/29/17.
 */
public class UserList {
    private static final UserList userList = new UserList();
    private HashMap<String, Person> users;

    /**
     * Returns the user list for the application
     * @return UserList
     */
    public static UserList getInstance() {
        return userList;
    }

    /**
     * Default contstructor.
     */
    private UserList() {
        users = new HashMap<String, Person>();
        addUser(new Person("user1", "pass", "", "", UserType.USER ));
        addUser(new Person("user2", "pass", "", "", UserType.WORKER ));
        addUser(new Person("user3", "pass", "", "", UserType.MANAGER ));
    }

    /**
     * Adds user to the userlist
     * @param person to be added
     */
    public void addUser(Person person) {
        users.put(person.getUsername(), person);
    }

    /**
     * Returns a user object by their string username
     * @param username in string form
     * @return Person the user with given username
     */
    public Person getUser(String username) {
        return users.get(username);
    }

    /**
     * Checks if a user is registered by username
     * @param username string username to look up
     * @return boolean whether user exists in the system.
     */
    public boolean isRegisteredUser(String username) {
        return users.containsKey(username);
    }
}
