package characters.angels;

import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;

/**
 * Implements visitor for Visitor pattern.
 */
public interface AngelInterface {
    void executeActionOn(Knight hero);

    void executeActionOn(Pyromancer hero);

    void executeActionOn(Rogue hero);

    void executeActionOn(Wizard hero);
}
