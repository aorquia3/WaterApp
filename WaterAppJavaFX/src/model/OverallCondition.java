package model;

/**
 * Created by TriciaPSRosario on 4/13/17.
 */
public enum OverallCondition {
    SAFE("Safe"), TREATABLE("Treatable"), UNSAFE("Unsafe");
    private final String name;

    OverallCondition(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
