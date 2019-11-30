package map.terrain;

import common.Constants;
import heroes.Hero;

public class Desert implements Terrain {

    @Override
    public char getType() {
        return Constants.DESERT;
    }

    @Override
    public float getTerrainMultiplierOf(Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
