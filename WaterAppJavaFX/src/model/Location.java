package model;

/**
 * Created by TriciaPSRosario on 4/13/17.
 */
public class Location {
    public double lat;
    public double lon;

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() { return lat; }
    public Double getLon() { return lon; }


    public String toString() {
        return String.format("lat: %.2f, lon: %.2f", lat, lon);
    }

}
