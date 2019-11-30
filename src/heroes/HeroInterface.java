package heroes;

import abilities.AbilityInterface;
import map.terrain.Desert;
import map.terrain.Land;
import map.terrain.Volcanic;
import map.terrain.Woods;

public interface HeroInterface {
    float getRaceMultiplierOf(AbilityInterface ability);

    float getTerrainBonusDamageMultiplier(Land terrain);

    float getTerrainBonusDamageMultiplier(Volcanic terrain);

    float getTerrainBonusDamageMultiplier(Desert terrain);

    float getTerrainBonusDamageMultiplier(Woods terrain);
}
