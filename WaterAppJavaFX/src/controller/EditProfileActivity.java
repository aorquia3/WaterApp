package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mainAppLauncher.MainAppLauncher;
import model.*;


/**
 * Created by TriciaPSRosario on 3/30/17.
 */
public class EditProfileActivity {
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
    private PasswordField password1;

    @FXML
    private PasswordField password2;

    @FXML
    public void initialize() {
        cancelButton.setOnAction(event -> mainApp.showHomescreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }

    @FXML
    protected void update() {
        Model model = Model.getInstance();
        Person currentUser = model.getCurrentUser();
        UserList users = UserList.getInstance();
        if (!nameTextField.getText().isEmpty()) {
            currentUser.setName(nameTextField.getText());
        }
        if (!usernameTextField.getText().isEmpty()) {
            currentUser.setUsername(usernameTextField.getText());
        }
        if (!emailTextField.getText().isEmpty()) {
            currentUser.setEmail(emailTextField.getText());
        }
        if (password1.getText().equals(password2.getText())) {
            currentUser.setPassword(password1.getText());
            users.addUser(currentUser);
            mainApp.showHomescreen(mainApp.getMainScreen());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Your passwords don't match");
            alert.showAndWait();
        }
    }
}
