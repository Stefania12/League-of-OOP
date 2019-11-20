package heroes;

import abilities.AbilityInterface;

public interface HeroInterface {
    float getTerrainBonusDamageMultiplier();

    void attack(Hero hero);

    float getRaceMultiplierOf(AbilityInterface ability);
}
