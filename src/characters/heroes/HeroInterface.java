package characters.heroes;

import abilities.AbilityInterface;
import characters.Observable;
import characters.angels.AngelInterface;
import map.terrain.Desert;
import map.terrain.Land;
import map.terrain.Volcanic;
import map.terrain.Woods;

/**
 * Implements interface for Visitor pattern for ability->hero and hero->terrain.
 */
public interface HeroInterface extends Observable {
    /**
     * Accept-type method that returns the value of the visit-type method of an ability.
     *
     * @param ability ability that hurts hero
     * @return race multiplier for the ability
     */
    float getRaceMultiplierOf(AbilityInterface ability);

    void receiveEffectOfAngel(AngelInterface angel);

    /**
     * Returns Land multiplier of hero.
     *
     * @param terrain Land terrain
     * @return Land multiplier
     */
    float getTerrainBonusDamageMultiplier(Land terrain);

    /**
     * Returns Volcanic multiplier of hero.
     *
     * @param terrain Volcanic terrain
     * @return Volcanic multiplier
     */
    float getTerrainBonusDamageMultiplier(Volcanic terrain);

    /**
     * Returns Desert multiplier of hero.
     * @param terrain   Desert terrain
     * @return Desert multiplier
     */
    float getTerrainBonusDamageMultiplier(Desert terrain);

    /**
     * Returns Woods multiplier of hero.
     * @param terrain   Woods terrain
     * @return Woods multiplier
     */
    float getTerrainBonusDamageMultiplier(Woods terrain);
}
