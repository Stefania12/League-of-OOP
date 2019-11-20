package abilities.knight;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import common.Constants;
import heroes.*;

public class Slam extends Ability {
    public Slam(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.SLAM_BASE_DAMAGE,
                Constants.SLAM_INCAPACITATION_ROUNDS, Constants.SLAM_DAMAGE_PER_LEVEL,
                Constants.SLAM_INCAPACITATION_ROUNDS, 0, 0);
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
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }
}
