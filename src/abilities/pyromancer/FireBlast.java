package abilities.pyromancer;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class FireBlast extends Ability implements AbilityInterface {
    public FireBlast(Hero hero) {
        super(hero, Constants.FIREBLAST_BASE_DAMAGE, Constants.FIREBLAST_DAMAGE_PER_LEVEL, 0, 0, 0);
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.FIREBLAST_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.FIREBLAST_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.FIREBLAST_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.FIREBLAST_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
