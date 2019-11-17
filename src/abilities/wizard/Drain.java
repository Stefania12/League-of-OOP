package abilities.wizard;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Drain extends Ability implements AbilityInterface {
    public Drain(Hero hero) {
        super(hero, Constants.DRAIN_BASE_DAMAGE_PERCENTAGE, Constants.DRAIN_DAMAGE_PERCENTAGE_PER_LEVEL, 0, 0, 0);
    }

    private int getBaseHP(Hero hero) {
        return Math.round(Math.min(Constants.DRAIN_BASE_HP_CONSTANT * hero.getMaxHP(), hero.getHP()));
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.DRAIN_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.DRAIN_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.DRAIN_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.DRAIN_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
