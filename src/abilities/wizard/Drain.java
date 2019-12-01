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

/**
 * Implements Drain ability.
 */
public class Drain extends Ability {
    private static final float BASE_HP_CONSTANT = Constants.DRAIN_BASE_HP_CONSTANT;

    /**
     * Initialize Drain ability.
     */
    public Drain(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.DRAIN_BASE_DAMAGE_PERCENTAGE, 0,
                Constants.DRAIN_DAMAGE_PERCENTAGE_PER_LEVEL, 0, 0, 0);
        this.setOwner(hero);
    }

    /**
     * Returns base hp integer percentage.
     *
     * @param hero hero to get base hp for
     * @return base hp of hero
     */
    private static int getBaseHP(final Hero hero) {
        return Math.round(Math.min(BASE_HP_CONSTANT * hero.getMaxHP(), hero.getHP()));
    }

    /**
     * Returns value of the basic damage on a hero.
     *
     * @param hero hero to attack
     * @return basic damage on hero
     */
    @Override
    protected int getBasicDamageOn(final Hero hero) {
        return Math.round(super.getBasicDamageOn(null) / Constants.PERCENTAGE * getBaseHP(hero));
    }

    /**
     * Returns race multiplier for Rogue opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Rogue hero) {
        return Constants.DRAIN_ROGUE_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Knight opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Knight hero) {
        return Constants.DRAIN_KNIGHT_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Wizard opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Wizard hero) {
        return Constants.DRAIN_WIZARD_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Pyromaner opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Pyromancer hero) {
        return Constants.DRAIN_PYROMANCER_MULTIPLIER;
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
