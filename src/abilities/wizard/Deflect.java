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

public class Deflect extends Ability {
    private final int maxDamagePercentage;

    public Deflect(Hero hero) {
        super(AbilityPriority.SECOND.ordinal(), hero, Constants.DEFLECT_BASE_DAMAGE_PERCENTAGE, 0, Constants.DEFLECT_DAMAGE_PERCENTAGE_PER_LEVEL, 0, 0, 0);
        maxDamagePercentage = Constants.DEFLECT_DAMAGE_MAX_PERCENTAGE;
    }

    private float getDamagePercentage() {
        int levelPercentage = this.getDamagePerLevel() * this.getOwner().getLevel();
        return Math.min(this.getBaseDamage() + levelPercentage, maxDamagePercentage) / 100.0f;
    }

    @Override
    public int getBasicDamageOn(Hero hero) {
        int damageGot = 0;
        for (AbilityParameters i : hero.getAttacks()) {
            damageGot += Math.round(i.getBasicDamage() * i.getTerrainMultiplier());
        }
        return Math.round(damageGot * this.getDamagePercentage());
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.DEFLECT_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.DEFLECT_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.DEFLECT_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.DEFLECT_PYROMANCER_MUTIPLIER;
    }

    @Override
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(),
                this.getOvertimeDamageRounds(), this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }

}
