package map.terrain;

import heroes.Hero;

public interface Terrain {
    float getTerrainMultiplierOf(Hero hero);

    char getType();
}
