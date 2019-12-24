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
    AngelEffect getEffectOn(Knight hero);

    AngelEffect getEffectOn(Pyromancer hero);

    AngelEffect getEffectOn(Rogue hero);

    AngelEffect getEffectOn(Wizard hero);
}
