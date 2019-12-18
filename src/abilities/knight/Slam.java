package abilities.knight;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;

/**
 * Implements Slam ability.
 */
public class Slam extends Ability {

    /**
     * Initializes aability.
     *
     * @param hero owner
     */
    public Slam(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.SLAM_BASE_DAMAGE,
                Constants.SLAM_INCAPACITATION_ROUNDS, Constants.SLAM_DAMAGE_PER_LEVEL,
                Constants.SLAM_INCAPACITATION_ROUNDS, 0, 0);
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
        return Constants.SLAM_ROGUE_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Knight opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Knight hero) {
        return Constants.SLAM_KNIGHT_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Wizard opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Wizard hero) {
        return Constants.SLAM_WIZARD_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Pyromaner opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Pyromancer hero) {
        return Constants.SLAM_PYROMANCER_MULTIPLIER;
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
