package map.terrain;

import common.Constants;
import heroes.Hero;

/**
 * Implements Volcanic terrain type.
 */
public final class Volcanic implements Terrain {

    @Override
    public char getType() {
        return Constants.VOLCANIC;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
