package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import mainAppLauncher.MainAppLauncher;
import model.Model;
import model.UserType;

/**
 * Created by TriciaPSRosario on 3/29/17.
 */
public class HomescreenActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button logout;

    @FXML
    private Button editProfile;

    @FXML
    private Button waterSourceReport;

    @FXML
    private Button viewWSReport;

    @FXML
    private Button waterPurityReport;

    @FXML
    private Button viewPReport;

    @FXML
    private Button waterAvailability;

    @FXML
    private Button historyGraph;

    @FXML
    public void initialize() {
        logout.setOnAction(event -> mainApp.showWelcomeScreen(mainApp.getMainScreen()));
        editProfile.setOnAction(event -> mainApp.showEditProfile(mainApp.getMainScreen()));
        waterSourceReport.setOnAction(event -> mainApp.showWaterSourceReport(mainApp.getMainScreen()));
        viewWSReport.setOnAction(event -> mainApp.showViewSourceReport(mainApp.getMainScreen()));
        if (Model.getInstance().getCurrentUser().getUserType() == UserType.WORKER
                || Model.getInstance().getCurrentUser().getUserType() == UserType.MANAGER) {
            waterPurityReport.setOnAction(event -> mainApp.showWaterPurityReport(mainApp.getMainScreen()));
            viewPReport.setOnAction(event -> mainApp.showViewPurityReport(mainApp.getMainScreen()));
        } else {
            waterPurityReport.setVisible(false);
            viewPReport.setVisible(false);
        }
        waterAvailability.setOnAction(event -> mainApp.showMap(mainApp.getMainScreen()));
        if (Model.getInstance().getCurrentUser().getUserType() == UserType.MANAGER) {
            historyGraph.setOnAction(event -> mainApp.showHistoryGraph(mainApp.getMainScreen()));
        } else {
            historyGraph.setVisible(false);
        }
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }
}
