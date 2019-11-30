package map.terrain;

import common.Constants;
import heroes.Hero;

public class Land implements Terrain {

    @Override
    public char getType() {
        return Constants.LAND;
    }

    @Override
    public float getTerrainMultiplierOf(Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
