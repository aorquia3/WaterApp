package model;

/**
 * Created by TriciaPSRosario on 4/9/17.
 */
public enum WaterType {
    BOTTLED("Bottled"), WELL("Well"), STREAM("Stream"), LAKE("Lake"), SPRING("Spring"), OTHER("Other");

    private final String name;

    WaterType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
