package map.terrain;

import heroes.Hero;

public interface Terrain {
    /**
     * Accept-type method that returns the value of the visit-type method
     * for the terrain multiplier.
     *
     * @param hero hero to get terrain multiplier of
     * @return terrain multiplier of hero
     */
    float getTerrainMultiplierOf(Hero hero);

    char getType();
}
