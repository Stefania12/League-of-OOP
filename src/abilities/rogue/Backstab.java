package abilities.rogue;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Backstab extends Ability implements AbilityInterface {
    private int criticalHits;

    public Backstab(Hero hero) {
        super(hero, Constants.BACKSTAB_BASE_DAMAGE, Constants.BACKSTAB_DAMAGE_PER_LEVEL, 0, 0, 0);
        criticalHits = Constants.BACKSTAB_CRITICAL_HITS;
    }

    private void resetCriticalHits() {
        criticalHits = 0;
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.BACKSTAB_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.BACKSTAB_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.BACKSTAB_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.BACKSTAB_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
