package map.terrain;

import common.Constants;
import heroes.Hero;

/**
 * Implements Desert terrain type.
 */
public final class Desert implements Terrain {

    @Override
    public char getType() {
        return Constants.DESERT;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
