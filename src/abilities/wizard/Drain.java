package abilities.wizard;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import common.Constants;
import heroes.Hero;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

public class Drain extends Ability {
    public Drain(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.DRAIN_BASE_DAMAGE_PERCENTAGE, 0,
                Constants.DRAIN_DAMAGE_PERCENTAGE_PER_LEVEL, 0, 0, 0);
    }

    private static int getBaseHP(Hero hero) {
        return Math.round(Math.min(Constants.DRAIN_BASE_HP_CONSTANT * hero.getMaxHP(), hero.getHP()));
    }

    @Override
    public int getBasicDamageOn(Hero hero) {
        float levelPercentage = this.getDamagePerLevel() * this.getOwner().getLevel();
        return Math.round((this.getBaseDamage() + levelPercentage) / 100.0f * getBaseHP(hero));
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
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getOvertimeDamageRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }

}
