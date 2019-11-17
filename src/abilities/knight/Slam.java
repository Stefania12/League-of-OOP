package abilities.knight;

import abilities.Ability;
import abilities.AbilityInterface;
import common.Constants;
import heroes.*;

public class Slam extends Ability implements AbilityInterface {
    public Slam(Hero hero) {
        super(hero, Constants.SLAM_BASE_DAMAGE, Constants.SLAM_DAMAGE_PER_LEVEL, Constants.SLAM_INCAPACITATION_ROUNDS, 0, 0);
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.SLAM_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.SLAM_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.SLAM_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.SLAM_PYROMANCER_MUTIPLIER;
    }

    @Override
    public void performAbility() {
    }
}
