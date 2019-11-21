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

public class Paralysis extends Ability {
    private final int roundsWoods;
    private final int roundsNotWoods;

    public Paralysis(Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), hero, Constants.PARALYSIS_DAMAGE_PER_ROUND, 0,
                Constants.PARALYSIS_ROUND_DAMAGE_PER_LEVEL, 0, Constants.PARALYSIS_DAMAGE_PER_ROUND,
                Constants.PARALYSIS_ROUND_DAMAGE_PER_LEVEL);
        roundsNotWoods = Constants.PARALYSIS_ROUNDS_NOT_WOODS;
        roundsWoods = Constants.PARALYSIS_ROUNDS_WOODS;
    }

    @Override
    public int getIncapacitationRounds() {
        if (Map.getInstance().getTerrainAt(this.getOwner().getCoordinates()) == Constants.WOODS) {
            return roundsWoods;
        }
        return roundsNotWoods;
    }

    @Override
    public float getRaceDamageMultiplier(Rogue hero) {
        return Constants.PARALYSIS_ROGUE_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Knight hero) {
        return Constants.PARALYSIS_KNIGHT_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Wizard hero) {
        return Constants.PARALYSIS_WIZARD_MUTIPLIER;
    }

    @Override
    public float getRaceDamageMultiplier(Pyromancer hero) {
        return Constants.PARALYSIS_PYROMANCER_MUTIPLIER;
    }

    @Override
    public AbilityParameters getAbilityParametersOn(Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getRoundDamage(), this.getOvertimeDamageRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
    }
}
