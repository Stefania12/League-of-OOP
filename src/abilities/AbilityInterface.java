package abilities;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public interface AbilityInterface {

    void performAbility();

    float getRaceDamageMultiplier(Pyromancer hero);

    float getRaceDamageMultiplier(Knight hero);

    float getRaceDamageMultiplier(Wizard hero);

    float getRaceDamageMultiplier(Rogue hero);
}
