package map;

import common.Constants;
import map.terrain.*;
import util.Pair;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Singleton map holding terrain types.
 */
public final class Map {
    private static Map instance = null;
    private ArrayList<String> lands;
    private LinkedHashMap<Character, TerrainInterface> terrainTypes;

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

    /**
     * Initializes land types.
     *
     * @param landTypes land types
     */
    public void initLands(final ArrayList<String> landTypes) {
        this.lands = landTypes;
    }

    /**
     * Returns terrain object corresponding to a set of coordinates.
     *
     * @param coordinates coordinates of terrain
     * @return terrain object
     */
    public TerrainInterface getTerrainAt(final Pair<Integer, Integer> coordinates) {
        char type = lands.get(coordinates.getKey()).charAt(coordinates.getValue());
        return terrainTypes.get(type);
    }
}
