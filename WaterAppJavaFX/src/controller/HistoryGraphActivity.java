package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import mainAppLauncher.MainAppLauncher;
import model.Model;
import model.PurityReport;

import java.util.ArrayList;

/**
 * Created by TriciaPSRosario on 4/18/17.
 */
public class HistoryGraphActivity {
    /** Reference back to mainApp if needed */
    private MainAppLauncher mainApp;

    @FXML
    private Button back;

    @FXML
    private TextField lat;

    @FXML
    private TextField lon;

    @FXML
    private TextField year;

    @FXML
    private ComboBox VorC;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    public void initialize() {
        lineChart.setTitle("Trends of water purity");
        xAxis.setLabel("Month");
        lineChart.setLegendVisible(false);
        back.setOnAction(event -> mainApp.showHomescreen(mainApp.getMainScreen()));
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }


    @FXML
    protected void submit() {
        Model model = Model.getInstance();
        ArrayList<PurityReport> list = model.graphPurity(model.getPurityList(),
                Integer.valueOf(lat.getText()), Integer.valueOf(lon.getText()), Integer.valueOf(year.getText()));

        XYChart.Series<String, Number> series = new XYChart.Series();

        yAxis.setLabel(VorC.getSelectionModel().getSelectedItem().toString());

        for (int i = 0; i < list.size(); i++) {
            if (VorC.getSelectionModel().getSelectedItem().equals("Virus")) {
                series.getData().add(new XYChart.Data<>(list.get(i).getDT().getMonth().toString(), Integer.valueOf(list.get(i).getVirusPPM())));
            } else {
                series.getData().add(new XYChart.Data<>(list.get(i).getDT().getMonth().toString(), Integer.valueOf(list.get(i).getContaminantPPM())));
            }
        }

        lineChart.getData().add(series);
    }
}
