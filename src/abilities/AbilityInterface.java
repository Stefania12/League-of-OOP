package abilities;

import heroes.Hero;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

public interface AbilityInterface {

    /**
     * Calculate ability parameters when attacking a hero.
     *
     * @param hero hero to attack
     * @return ability parameters
     */
    AbilityParameters getAbilityParametersOn(Hero hero);

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
