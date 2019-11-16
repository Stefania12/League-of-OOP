package map;

import java.util.ArrayList;

public final class Map {
    private final ArrayList<String> lands;

    public Map(final ArrayList<String> lands) {
        this.lands = lands;
    }

    public ArrayList<String> getLands() {
        return lands;
    }

    @Override
    public String toString() {
        return lands.toString();
    }
}
