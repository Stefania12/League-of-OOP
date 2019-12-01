package map.terrain;

import common.Constants;
import heroes.Hero;

/**
 * Implements Land terrain type.
 */
public final class Land implements Terrain {

    @Override
    public char getType() {
        return Constants.LAND;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
