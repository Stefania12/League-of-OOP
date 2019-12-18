package abilities;

import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;

/**
 * Implements visitor interface for Visitor pattern (ability->hero).
 */
public interface AbilityInterface {
    /**
     * Visit-type method to get race multiplier on Pyromancer.
     *
     * @param hero hero
     * @return race multiplier
     */
    float getRaceDamageMultiplier(Pyromancer hero);

    /**
     * Visit-type method to get race multiplier on Knight.
     * @param hero  hero
     * @return race multiplier
     */
    float getRaceDamageMultiplier(Knight hero);

    /**
     * Visit-type method to get race multiplier on Wizard.
     * @param hero  hero
     * @return race multiplier
     */
    float getRaceDamageMultiplier(Wizard hero);

    /**
     * Visit-type method to get race multiplier on Rogue.
     * @param hero  hero
     * @return race multiplier
     */
    float getRaceDamageMultiplier(Rogue hero);
}
