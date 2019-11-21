package abilities;

import heroes.Hero;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

public interface AbilityInterface {

    AbilityParameters getAbilityParametersOn(Hero hero);

    float getRaceDamageMultiplier(Pyromancer hero);
    float getRaceDamageMultiplier(Knight hero);
    float getRaceDamageMultiplier(Wizard hero);
    float getRaceDamageMultiplier(Rogue hero);
}
