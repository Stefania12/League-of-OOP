package abilities.rogue;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import common.Constants;
import heroes.Hero;
import heroes.races.Knight;
import heroes.races.Pyromancer;
import heroes.races.Rogue;
import heroes.races.Wizard;
import map.Map;

public class Backstab extends Ability {
    private int counter;
    public Backstab(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.BACKSTAB_BASE_DAMAGE, 0,
                Constants.BACKSTAB_DAMAGE_PER_LEVEL, 0, 0, 0);
    }

    private void decreaseCounter() {
        if (counter - 1 == 0) {
            counter = Constants.BACKSTAB_CRITICAL_HITS;
        } else {
            counter--;
        }
    }

    private float getCriticalValue() {
        if (Map.getInstance().getTerrainAt(this.getOwner().getCoordinates()) == Constants.WOODS
                && counter == Constants.BACKSTAB_CRITICAL_HITS) {
            return Constants.BACKSTAB_CRITICAL_PERCENTAGE;
        }
        return 1.0f;
    }

    @Override
    public int getBasicDamageOn(Hero hero) {
        return Math.round(super.getBasicDamageOn(hero) * this.getCriticalValue());
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.BACKSTAB_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.BACKSTAB_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.BACKSTAB_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.BACKSTAB_PYROMANCER_MUTIPLIER;
    }

    @Override
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        AbilityParameters a = new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getOvertimeDamageRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
        this.decreaseCounter();
        return a;
    }
}
