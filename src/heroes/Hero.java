package heroes;

import javafx.util.Pair;

public class Hero {
    protected final String type;
    protected Pair<Integer, Integer> coordinates;

    public Hero(String type, Pair<Integer, Integer> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }


    @Override
    public String toString() {
        return type + " " + coordinates;
    }
}
