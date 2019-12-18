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
 * Implements Execute ability.
 */
public class Execute extends Ability {
    private static final int INITIAL_HP_PERCENTAGE = Constants.EXECUTE_INITIAL_HP_PERCENTAGE;
    private static final int HP_PERCENTAGE_PER_LVL = Constants.EXECUTE_HP_PERCENTAGE_PER_LEVEL;
    private static final int MAX_HP_PERCENTAGE = Constants.EXECUTE_MAX_HP_PERCENTAGE;

    /**
     * Initializes ability.
     *
     * @param hero owner
     */
    public Execute(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.EXECUTE_BASE_DAMAGE, 0,
                Constants.EXECUTE_DAMAGE_PER_LEVEL, 0, 0, 0);
        this.setOwner(hero);
    }

    private int getHPLimit(final Hero hero) {
        int percentage = INITIAL_HP_PERCENTAGE + HP_PERCENTAGE_PER_LVL * getOwner().getLevel();
        float hp = Math.min(MAX_HP_PERCENTAGE, percentage) / Constants.PERCENTAGE * hero.getMaxHP();
        return Math.round(hp);
    }

    /**
     * Get basic damage on hero.
     *
     * @param hero hero to attack
     * @return basic damage
     */
    @Override
    protected int getBasicDamageOn(final Hero hero) {
        if (hero.getHP() < getHPLimit(hero)) {
            return hero.getHP();
        }
        return super.getBasicDamageOn(null);
    }

    /**
     * Returns race multiplier for Rogue opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Rogue hero) {
        return Constants.EXECUTE_ROGUE_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Knight opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Knight hero) {
        return Constants.EXECUTE_KNIGHT_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Wizard opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Wizard hero) {
        return Constants.EXECUTE_WIZARD_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Pyromaner opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Pyromancer hero) {
        return Constants.EXECUTE_PYROMANCER_MULTIPLIER;
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
