package map.terrain;

import common.Constants;
import heroes.Hero;

public class Volcanic implements Terrain {

    @Override
    public char getType() {
        return Constants.VOLCANIC;
    }

    @Override
    public float getTerrainMultiplierOf(Hero hero) {
        return hero.getTerrainBonusDamageMultiplier(this);
    }
}
