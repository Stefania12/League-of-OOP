package abilities.pyromancer;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Ignite extends Ability implements AbilityInterface {
    public Ignite(Hero hero) {
        super(hero, Constants.IGNITE_BASE_DAMAGE, Constants.IGNITE_DAMAGE_PER_LEVEL,
                Constants.IGNITE_ROUNDS, Constants.IGNITE_DAMAGE_PER_ROUND,
                Constants.IGNITE_ROUND_DAMAGE_PER_LEVEL);
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.IGNITE_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.IGNITE_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.IGNITE_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.IGNITE_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
