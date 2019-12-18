package map.terrain;

import characters.heroes.Hero;
import common.Constants;

/**
 * Implements Woods terrain type.
 */
public final class Woods implements TerrainInterface {

    @Override
    public char getType() {
        return Constants.WOODS;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
