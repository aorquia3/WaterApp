package controller;

import javafx.scene.control.*;
import model.*;
import mainAppLauncher.MainAppLauncher;
import javafx.fxml.FXML;

/**
 * Created by TriciaPSRosario on 3/28/17.
 */
public class RegistrationActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField1;

    @FXML
    private PasswordField passwordTextField2;

    @FXML
    private ComboBox<String> userTypeComboBox;

    @FXML
    public void initialize() {
        cancelButton.setOnAction(event -> mainApp.showWelcomeScreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainAppLauncher main) {
        mainApp = main;
    }

    @FXML
    protected void register() {
        if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || usernameTextField.getText().isEmpty()
                || passwordTextField1.getText().isEmpty() || passwordTextField2.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fill all the present fields");
            alert.showAndWait();
        }
        Model model = Model.getInstance();
        Person user;
        UserList users = UserList.getInstance();
        String type = userTypeComboBox.getSelectionModel().getSelectedItem();
        switch (type) {
            case "User":
                user = new User();
                user.setUserType(UserType.USER);
                break;
            case "Worker":
                user = new Worker();
                user.setUserType(UserType.WORKER);
                break;
            case "Manager":
                user = new Manager();
                user.setUserType(UserType.MANAGER);
                break;
            case "Admin":
                user = new Admin();
                user.setUserType(UserType.ADMIN);
                break;
            default:
                user = new User();
                break;
        }
        user.setName(nameTextField.getText());
        user.setUsername(usernameTextField.getText());
        user.setEmail(emailTextField.getText());
        if (passwordTextField1.getText().equals(passwordTextField2.getText())) {
            user.setPassword(passwordTextField1.getText());
            //Add the user to registered users
            users.addUser(user);
            model.setCurrentUser(user);
            mainApp.showLoginScreen(mainApp.getMainScreen());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Your passwords don't match");
            alert.showAndWait();
        }
    }
}
