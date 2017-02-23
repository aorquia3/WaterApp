package users;

/**
 * Created by aaron on 2/23/17.
 */
public class Model {
    private static Model ourInstance = new Model();
    public static Model getInstance() {
        return ourInstance;
    }

    private Person currentUser;

    private Model() {
        currentUser = null;
    }

    public void setCurrentUser(Person person) {
        this.currentUser = person;
    }

    public Person getCurrentUser() {
        return currentUser;
    }
}
