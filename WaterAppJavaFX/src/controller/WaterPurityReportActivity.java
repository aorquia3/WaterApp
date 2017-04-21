package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import mainAppLauncher.MainAppLauncher;
import model.*;

/**
 * Created by TriciaPSRosario on 4/13/17.
 */
public class WaterPurityReportActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button cancel;

    @FXML
    private ComboBox<String> condition;

    @FXML
    private TextField virus;

    @FXML
    private TextField contaminant;

    @FXML
    private TextField lat;

    @FXML
    private TextField lon;

    @FXML
    public void initialize() {
        cancel.setOnAction(event -> mainApp.showHomescreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }

    @FXML
    protected void add() {
        Model model = Model.getInstance();

        PurityReport PR = new PurityReport();
        String OCondition = condition.getSelectionModel().getSelectedItem();
        switch (OCondition) {
            case "Safe":
                PR.setCondition(OverallCondition.SAFE);
                break;
            case "Treatable":
                PR.setCondition(OverallCondition.TREATABLE);
                break;
            case "Unsafe":
                PR.setCondition(OverallCondition.UNSAFE);
                break;
        }
        PurityReport purityReport = new PurityReport(PR.getOverallCondition(), virus.getText(), contaminant.getText(),
                Double.parseDouble(lat.getText()),
                Double.parseDouble(lon.getText()));

        model.addToPurityList(purityReport);
        mainApp.showHomescreen(mainApp.getMainScreen());
    }
}
