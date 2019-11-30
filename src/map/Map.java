package map;

import common.Constants;
import general.Pair;
import map.terrain.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class Map {
    private static Map instance = null;
    private ArrayList<String> lands;
    private LinkedHashMap<Character, Terrain> terrainTypes;

    private Map() {
        terrainTypes = new LinkedHashMap<>();
        terrainTypes.put(Constants.DESERT, new Desert());
        terrainTypes.put(Constants.LAND, new Land());
        terrainTypes.put(Constants.VOLCANIC, new Volcanic());
        terrainTypes.put(Constants.WOODS, new Woods());
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

    public Terrain getTerrainAt(final Pair<Integer, Integer> coordinates) {
        //return lands.get(coordinates.getKey()).charAt(coordinates.getValue());
        char type = lands.get(coordinates.getKey()).charAt(coordinates.getValue());
        return terrainTypes.get(type);
    }

    @Override
    public String toString() {
        return lands.toString();
    }
}
