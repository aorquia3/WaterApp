package model;

/**
 * Created by TriciaPSRosario on 4/9/17.
 */
public enum WaterCondition {
    WASTE("Waste"), TREATABLECLEAR("Treatable Clear"), TREATABLEMUDDY("Treatable Muddy"), PORTABLE("Portable");
    private final String name;

    WaterCondition(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
