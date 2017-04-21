package controller;

import mainAppLauncher.MainAppLauncher;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 * Created by TriciaPSRosario on 3/12/17.
 */
public class WelcomeActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    public void initialize() {
        loginButton.setOnAction(event -> mainApp.showLoginScreen(mainApp.getMainScreen()));
        registerButton.setOnAction(event -> mainApp.showRegistrationScreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(MainAppLauncher main) { mainApp = main; }
}
