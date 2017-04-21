package mainAppLauncher;

import com.lynden.gmapsfx.GoogleMapView;
import controller.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by TriciaPSRosario on 3/12/17.
 */
public class MainAppLauncher extends Application {
    /**  The java logger for this class */
    private static final Logger LOGGER = Logger.getLogger("mainAppLauncher");

    /** The main container for the application window */
    private Stage mainScreen;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainScreen = primaryStage;
        showWelcomeScreen(mainScreen);
    }

    /**
     * Returns a reference to the main window stage
     * @return reference to main stage
     */
    public Stage getMainScreen() {
        return mainScreen;
    }

    /**
     * Initializes the Welcome Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showWelcomeScreen(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_welcome.fxml"));
            Pane welcomeScreen = loader.load();

            // Give the controller access to the main app.
            WelcomeActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(welcomeScreen);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Welcome Screen!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Login Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showLoginScreen(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_login.fxml"));
            Pane loginScreen = loader.load();

            // Give the controller access to the main app.
            LoginActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(loginScreen);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Login Screen!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Registration Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showRegistrationScreen(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_registration.fxml"));
            Pane registrationScreen = loader.load();

            // Give the controller access to the main app.
            RegistrationActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(registrationScreen);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Registration Screen!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Home Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showHomescreen(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_homescreen.fxml"));
            Pane homescreenScreen = loader.load();

            // Give the controller access to the main app.
            HomescreenActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(homescreenScreen);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Homescreen!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Edit Profile Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showEditProfile(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_editProfile.fxml"));
            Pane editProfileScreen = loader.load();

            // Give the controller access to the main app.
            EditProfileActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(editProfileScreen);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Edit Profile!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Water Source Report Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showWaterSourceReport(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_waterSourceReport.fxml"));
            Pane waterSourceReport = loader.load();

            // Give the controller access to the main app.
            WaterSourceReportActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(waterSourceReport);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Water Source Report!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the View Water Source Report Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showViewSourceReport(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_viewSourceReports.fxml"));
            Pane viewSourceReport = loader.load();

            // Give the controller access to the main app.
            ViewSourceReportActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(viewSourceReport);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (Exception e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for View Source Report!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Purity Report Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showWaterPurityReport(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_purityReport.fxml"));
            Pane waterPurityReport = loader.load();

            // Give the controller access to the main app.
            WaterPurityReportActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(waterPurityReport);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (IOException e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Purity Report!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the View Purity Report Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showViewPurityReport(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_viewPurityReports.fxml"));
            Pane viewPurityReport = loader.load();

            // Give the controller access to the main app.
            ViewPurityReportActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(viewPurityReport);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (Exception e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for View Purity Report!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the Google Map Screen.
     * @param stage the main stage window of the application
     */
    public void showMap(Stage stage) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_googleMap.fxml"));
            GoogleMapView map = loader.load();

            // Give the controller access to the main app.
            MapActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(map);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (Exception e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for Google Map!");
            e.printStackTrace();
        }
    }

    /**
     * Initializes the History Graph Screen.
     * @param mainScreen the main stage window of the application
     */
    public void showHistoryGraph(Stage mainScreen) {
        try {
            // Load layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainAppLauncher.MainAppLauncher.class.getResource("../view/activity_historyGraph.fxml"));
            Pane viewHistoryGraph = loader.load();

            // Give the controller access to the main app.
            HistoryGraphActivity controller = loader.getController();
            controller.setMainApp(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(viewHistoryGraph);
            mainScreen.setScene(scene);
            mainScreen.show();

        } catch (Exception e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Failed to find the fxml file for History Graph!");
            e.printStackTrace();
        }
    }
}
