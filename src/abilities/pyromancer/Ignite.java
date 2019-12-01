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

/**
 * Implements Ignite ability.
 */
public class Ignite extends Ability {

    /**
     * Initialize ability.
     *
     * @param hero owner
     */
    public Ignite(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.IGNITE_BASE_DAMAGE, 0,
                Constants.IGNITE_DAMAGE_PER_LEVEL, Constants.IGNITE_ROUNDS,
                Constants.IGNITE_DAMAGE_PER_ROUND, Constants.IGNITE_ROUND_DAMAGE_PER_LEVEL);
        this.setOwner(hero);
    }

    /**
     * Returns race multiplier for Rogue opponent.
     *
     * @param hero hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Rogue hero) {
        return Constants.IGNITE_ROGUE_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Knight opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Knight hero) {
        return Constants.IGNITE_KNIGHT_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Wizard opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Wizard hero) {
        return Constants.IGNITE_WIZARD_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Pyromaner opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Pyromancer hero) {
        return Constants.IGNITE_PYROMANCER_MULTIPLIER;
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
