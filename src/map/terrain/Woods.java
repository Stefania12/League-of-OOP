package map.terrain;

import common.Constants;
import heroes.Hero;

public class Woods implements Terrain {

    @Override
    public char getType() {
        return Constants.WOODS;
    }

    @Override
    public float getTerrainMultiplierOf(Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
