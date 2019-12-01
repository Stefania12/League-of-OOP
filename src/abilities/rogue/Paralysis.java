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

/**
 * Implements Paralysis ability.
 */
public class Paralysis extends Ability {
    private static final int ROUNDS_WOODS = Constants.PARALYSIS_ROUNDS_WOODS;
    private static final int ROUNDS_NOT_WOODS = Constants.PARALYSIS_ROUNDS_NOT_WOODS;

    /**
     * Initialize ability.
     *
     * @param hero owner
     */
    public Paralysis(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.PARALYSIS_DAMAGE_PER_ROUND, 0,
                Constants.PARALYSIS_ROUND_DAMAGE_PER_LEVEL, 0, Constants.PARALYSIS_DAMAGE_PER_ROUND,
                Constants.PARALYSIS_ROUND_DAMAGE_PER_LEVEL);
        this.setOwner(hero);
    }

    /**
     * Returns the number of rounds with incapacitation.
     *
     * @return incapacitation rounds
     */
    @Override
    protected int getIncapacitationRounds() {
        char terrain = Map.getInstance().getTerrainAt(this.getOwner().getCoordinates()).getType();
        if (terrain == Constants.WOODS) {
            return ROUNDS_WOODS;
        }
        return ROUNDS_NOT_WOODS;
    }

    /**
     * Returns number of rounds with overtime damage.
     * @return overtime damage rounds
     */
    @Override
    protected int getOvertimeDamageRounds() {
        return getIncapacitationRounds();
    }

    /**
     * Returns race multiplier for Rogue opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Rogue hero) {
        return Constants.PARALYSIS_ROGUE_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Knight opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Knight hero) {
        return Constants.PARALYSIS_KNIGHT_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Wizard opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Wizard hero) {
        return Constants.PARALYSIS_WIZARD_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Pyromaner opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Pyromancer hero) {
        return Constants.PARALYSIS_PYROMANCER_MULTIPLIER;
    }

    /**
     * Calculates ability parameters when attacking a hero.
     * @param hero  hero to attack
     * @return parameters of ability
     */
    @Override
    public AbilityParameters getAbilityParametersOn(final Hero hero) {
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getTotalOvertimeDamage(),
                this.getOvertimeDamageRounds(), this.getTerrainMultiplier(),
                hero.getRaceMultiplierOf(this));
    }
}
