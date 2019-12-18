package map.terrain;

import characters.heroes.Hero;
import common.Constants;

/**
 * Implements Volcanic terrain type.
 */
public final class Volcanic implements TerrainInterface {

    @Override
    public char getType() {
        return Constants.VOLCANIC;
    }

    @Override
    public float getTerrainMultiplierOf(final Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
