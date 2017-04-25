package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import mainAppLauncher.MainAppLauncher;
import model.Model;
import model.WaterSource;

/**
 * Created by TriciaPSRosario on 4/10/17.
 */
public class ViewSourceReportActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private ListView<WaterSource> list;

    @FXML
    private Button back;

    @FXML
    public void initialize() {
        list.getItems().addAll(Model.getInstance().getSourceList());
        back.setOnAction(event -> mainApp.showHomescreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }
}
