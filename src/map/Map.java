package map;

import java.util.ArrayList;

public final class Map {
    private static Map instance = null;
    private ArrayList<String> lands = null;

    public Map() {
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public void initLands(ArrayList<String> lands) {
        this.lands = lands;
    }

    public ArrayList<String> getLands() {
        return lands;
    }

    public char getTerrainAt(final int x, final int y) {
        return getInstance().lands.get(x).charAt(y);
    }

    @Override
    public String toString() {
        return lands.toString();
    }
}
