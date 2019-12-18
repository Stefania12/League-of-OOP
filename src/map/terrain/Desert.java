package map.terrain;

import characters.heroes.Hero;
import common.Constants;

/**
 * Implements Desert terrain type.
 */
public final class Desert implements TerrainInterface {

    @Override
    public char getType() {
        return Constants.DESERT;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
