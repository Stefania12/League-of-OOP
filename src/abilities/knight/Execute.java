package abilities.knight;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import common.Constants;
import heroes.Hero;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

public class Execute extends Ability {
    public Execute(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.EXECUTE_BASE_DAMAGE, 0,
                Constants.EXECUTE_DAMAGE_PER_LEVEL, 0, 0, 0);
    }

    private static int getHPLimit(Hero hero) {
        int percentage = Constants.EXECUTE_INITIAL_HP_PERCENTAGE
                + Constants.EXECUTE_HP_PERCENTAGE_PER_LEVEL;
        float HP = Math.min(Constants.EXECUTE_MAX_HP_PERCENTAGE, percentage) / 100.0f * hero.getMaxHP();
        return Math.round(HP);
    }

    @Override
    public int getBasicDamageOn(Hero hero) {
        if (hero.getHP() < getHPLimit(hero)) {
            return hero.getHP();
        }
        int basic = this.getBaseDamage() + this.getDamagePerLevel() * this.getOwner().getLevel();
        return Math.round((basic) * this.getOwner().getTerrainBonusDamageMultiplier());
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
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getOvertimeDamageRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }
}
