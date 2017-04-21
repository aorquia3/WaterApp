package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.fxml.FXML;
import mainAppLauncher.MainAppLauncher;
import model.Model;
import model.WaterSource;
import netscape.javascript.JSObject;

import java.util.ArrayList;


/**
 * Created by TriciaPSRosario on 4/17/17.
 */
public class MapActivity implements MapComponentInitializedListener {
    @FXML
    GoogleMapView mapView;

    GoogleMap map;

    private MainAppLauncher mainApp;

    @FXML
    public void initialize() {
        mapView.addMapInializedListener(this);
    }

    /**
     * Allow to call back to the main application code if necessary
     * @param main the reference to the FX Application instance
     * */
    public void setMainApp(mainAppLauncher.MainAppLauncher main) { mainApp = main; }

    @Override
    public void mapInitialized() {
        MapOptions mapOptions = new MapOptions();
        mapOptions.center(new LatLong(33.778463,-84.398881))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);

        map = mapView.createMap(mapOptions);

        map.addUIEventHandler(UIEventType.rightclick, obj -> {
            mainApp.showHomescreen(mainApp.getMainScreen());
        });

        Model model = Model.getInstance();
        ArrayList<WaterSource> sourceList = model.getSourceList();

        for (int i = 0; i < sourceList.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions();

            markerOptions.position(new LatLong(sourceList.get(i).getLat(), sourceList.get(i).getLon()))
                    .visible(Boolean.TRUE)
                    .title("My Marker");

            Marker marker = new Marker(markerOptions);

            String returnInfo = "By: " + sourceList.get(i).getReporter()
                    + " Water type: " + sourceList.get(i).getWaterType()
                    + " Water condition: " + sourceList.get(i).getWaterCondition();

            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                        infoWindowOptions.content(returnInfo);

                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });

            map.addMarker(marker);
        }
    }
}
