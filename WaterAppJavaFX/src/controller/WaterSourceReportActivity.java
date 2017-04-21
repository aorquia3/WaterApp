package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import mainAppLauncher.MainAppLauncher;
import model.*;

/**
 * Created by TriciaPSRosario on 4/9/17.
 */
public class WaterSourceReportActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button cancel;

    @FXML
    private ComboBox<String> waterType;

    @FXML
    private ComboBox<String> waterCondition;

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
    protected void addReport() {
        Model model = Model.getInstance();

        WaterSource WS = new WaterSource();;
        String WType = waterType.getSelectionModel().getSelectedItem();
        switch (WType) {
            case "Bottled":
                WS.setWaterType(WaterType.BOTTLED);
                break;
            case "Well":
                WS.setWaterType(WaterType.WELL);
                break;
            case "Stream":
                WS.setWaterType(WaterType.STREAM);
                break;
            case "Lake":
                WS.setWaterType(WaterType.LAKE);
                break;
            case "Spring":
                WS.setWaterType(WaterType.SPRING);
                break;
            case "Other":
                WS.setWaterType(WaterType.OTHER);
                break;
        }

        String WCondition = waterCondition.getSelectionModel().getSelectedItem();
        switch (WCondition) {
            case "Waste":
                WS.setWaterCondition(WaterCondition.WASTE);
                break;
            case "Treatable Clear":
                WS.setWaterCondition(WaterCondition.TREATABLECLEAR);
                break;
            case "Treatable Muddy":
                WS.setWaterCondition(WaterCondition.TREATABLEMUDDY);
                break;
            case "Portable":
                WS.setWaterCondition(WaterCondition.PORTABLE);
                break;
        }

        WaterSource waterSource = new WaterSource(WS.getWaterType(), WS.getWaterCondition(),
                Double.parseDouble(lat.getText()),
                Double.parseDouble(lon.getText()));

        model.addToSources(waterSource);
        mainApp.showHomescreen(mainApp.getMainScreen());
    }
}
