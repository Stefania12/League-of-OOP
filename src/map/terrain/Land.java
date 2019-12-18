package map.terrain;

import characters.heroes.Hero;
import common.Constants;

/**
 * Implements Land terrain type.
 */
public final class Land implements TerrainInterface {

    @Override
    public char getType() {
        return Constants.LAND;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
