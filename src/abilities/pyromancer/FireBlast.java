package abilities.pyromancer;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import common.Constants;
import heroes.Hero;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;

public class FireBlast extends Ability {
    public FireBlast(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.FIREBLAST_BASE_DAMAGE, 0,
                Constants.FIREBLAST_DAMAGE_PER_LEVEL, 0, 0, 0);
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
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getOvertimeDamageRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }
}
