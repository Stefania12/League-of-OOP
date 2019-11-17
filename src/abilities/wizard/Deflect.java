package abilities.wizard;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Deflect extends Ability implements AbilityInterface {
    private final int maxDamagePercentage;

    public Deflect(Hero hero) {
        super(hero, Constants.DEFLECT_BASE_DAMAGE_PERCENTAGE, Constants.DEFLECT_DAMAGE_PERCENTAGE_PER_LEVEL, 0, 0, 0);
        maxDamagePercentage = Constants.DEFLECT_DAMAGE_MAX_PERCENTAGE;
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.DEFLECT_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.DEFLECT_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.DEFLECT_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.DEFLECT_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
