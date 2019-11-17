package abilities.knight;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Execute extends Ability implements AbilityInterface {
    public Execute(Hero hero) {
        super(hero, Constants.EXECUTE_BASE_DAMAGE, Constants.EXECUTE_DAMAGE_PER_LEVEL, 0, 0, 0);
    }

    private int getHPLimit(Hero hero) {
        int percentage = Constants.EXECUTE_INITIAL_HP_PERCENTAGE
                + Constants.EXECUTE_HP_PERCENTAGE_PER_LEVEL;
        float HP = Math.min(Constants.EXECUTE_MAX_HP_PERCENTAGE, percentage) / 100.0f * hero.getMaxHP();
        return Math.round(HP);
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.EXECUTE_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.EXECUTE_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.EXECUTE_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.EXECUTE_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
