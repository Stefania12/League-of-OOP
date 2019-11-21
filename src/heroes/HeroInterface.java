package heroes;

import abilities.AbilityInterface;

public interface HeroInterface {
    float getTerrainBonusDamageMultiplier();
    float getRaceMultiplierOf(AbilityInterface ability);
}
