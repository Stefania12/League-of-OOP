package characters.angels;

import characters.Observable;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;

/**
 * Implements visitor for Visitor pattern.
 */
public interface AngelInterface extends Observable {
    /**
     * Visitor-type function that returns the effects on the knight race.
     *
     * @param hero hero
     * @return effects
     */
    AngelEffect getEffectOn(Knight hero);

    /**
     * Visitor-type function that returns the effects on the pyromancer race.
     * @param hero  hero
     * @return effects
     */
    AngelEffect getEffectOn(Pyromancer hero);

    /**
     * Visitor-type function that returns the effects on the rogue race.
     * @param hero  hero
     * @return effects
     */
    AngelEffect getEffectOn(Rogue hero);

    /**
     * Visitor-type function that returns the effects on the wizard race.
     * @param hero  hero
     * @return effects
     */
    AngelEffect getEffectOn(Wizard hero);
}
