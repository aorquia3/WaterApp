package controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mainAppLauncher.MainAppLauncher;
import javafx.fxml.FXML;
import model.*;

/**
 * Created by TriciaPSRosario on 3/15/17.
 */
public class LoginActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;


    @FXML
    public void initialize() {
        cancelButton.setOnAction(event -> mainApp.showWelcomeScreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) {
        mainApp = main;
    }

    @FXML
    protected void login() {
        UserList users = UserList.getInstance();
        if (users.isRegisteredUser(usernameTextField.getText())
                && users.getUser(usernameTextField.getText()).getPassword().equals(passwordTextField.getText())) {
            Model.getInstance().setCurrentUser(UserList.getInstance().getUser(usernameTextField.getText()));
            mainApp.showHomescreen(mainApp.getMainScreen());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Your username and password is incorrect");
            alert.showAndWait();
        }

        Model model = Model.getInstance();
        WaterSource newSource = new WaterSource(WaterType.BOTTLED, WaterCondition.WASTE, 33.7756, -84.3963);
        model.addToSources(newSource);

        PurityReport newPurity = new PurityReport(OverallCondition.SAFE, "56", "67", 12.0, 34.0);
        model.addToPurityList(newPurity);
    }
}
