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

    public void initLands(final ArrayList<String> landTypes) {
        this.lands = landTypes;
    }

    public Terrain getTerrainAt(final Pair<Integer, Integer> coordinates) {
        char type = lands.get(coordinates.getKey()).charAt(coordinates.getValue());
        return terrainTypes.get(type);
    }
}
