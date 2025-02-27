package map.terrain;

import characters.heroes.Hero;

/**
 * Implements interface for terrain as Visited type in Visitor pattern (hero->terrain).
 */
public interface TerrainInterface {
    /**
     * Accept-type method that returns the value of the visit-type method
     * for the terrain multiplier.
     * @param hero hero to get terrain multiplier of
     * @return terrain multiplier of hero
     */
    float getTerrainMultiplierOf(Hero hero);

    char getType();
}
