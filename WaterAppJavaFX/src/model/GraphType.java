package model;

/**
 * Created by TriciaPSRosario on 4/18/17.
 */
public enum GraphType {
    CONT("Contaminant"), VIRUS("Virus");

    private final String name;

    GraphType(String name) {this.name = name;}

    @Override
    public String toString() {
        return name;
    }
}
