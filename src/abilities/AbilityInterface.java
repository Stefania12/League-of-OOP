package abilities;

import heroes.*;

public interface AbilityInterface {

    AbilityParameters getAbilityParametersOn(Hero hero);

    float getRaceDamageMultiplier(Pyromancer hero);
    float getRaceDamageMultiplier(Knight hero);
    float getRaceDamageMultiplier(Wizard hero);
    float getRaceDamageMultiplier(Rogue hero);
}
