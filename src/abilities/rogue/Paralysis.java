package abilities.rogue;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Paralysis extends Ability implements AbilityInterface {
    private final int roundsWoods;
    private final int roundsNotWoods;

    public Paralysis(Hero hero) {
        super(hero, Constants.PARALYSIS_DAMAGE_PER_ROUND, Constants.PARALYSIS_ROUND_DAMAGE_PER_LEVEL, 0, Constants.PARALYSIS_DAMAGE_PER_ROUND, Constants.PARALYSIS_ROUND_DAMAGE_PER_LEVEL);
        roundsNotWoods = Constants.PARALYSIS_ROUNDS_NOT_WOODS;
        roundsWoods = Constants.PARALYSIS_ROUNDS_WOODS;
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.PARALYSIS_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.PARALYSIS_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.PARALYSIS_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.PARALYSIS_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
