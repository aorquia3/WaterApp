package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import mainAppLauncher.MainAppLauncher;
import model.Model;
import model.PurityReport;

/**
 * Created by TriciaPSRosario on 4/13/17.
 */
public class ViewPurityReportActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private ListView<PurityReport> list;

    @FXML
    private Button back;

    @FXML
    public void initialize() {
        list.getItems().addAll(Model.getInstance().getPurityList());
        back.setOnAction(event -> mainApp.showHomescreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }
}
