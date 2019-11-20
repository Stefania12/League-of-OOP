package abilities.pyromancer;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import common.Constants;
import heroes.*;

public class Ignite extends Ability {
    public Ignite(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.IGNITE_BASE_DAMAGE, 0,
                Constants.IGNITE_DAMAGE_PER_LEVEL, Constants.IGNITE_ROUNDS,
                Constants.IGNITE_DAMAGE_PER_ROUND, Constants.IGNITE_ROUND_DAMAGE_PER_LEVEL);
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
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }
}
