package abilities.wizard;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import common.Constants;

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
        this.initializeDamageMultipliers(Constants.DRAIN_KNIGHT_MULTIPLIER,
                Constants.DRAIN_PYROMANCER_MULTIPLIER, Constants.DRAIN_ROGUE_MULTIPLIER,
                Constants.DRAIN_WIZARD_MULTIPLIER);
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
        return getBaseHP(hero);
    }

    /**
     * Calculates ability parameters when attacking a hero.
     * @param hero  hero to attack
     * @return parameters of ability
     */
    @Override
    public AbilityParameters getAbilityParametersOn(final Hero hero) {
        float newPercentage = super.getBasicDamageOn(null) / Constants.PERCENTAGE * this.getTerrainMultiplier() * hero.getRaceMultiplierOf(this);
        return new AbilityParameters(this.getPriority(), this.getBasicDamageOn(hero),
                this.getIncapacitationRounds(), this.getTotalOvertimeDamage(),
                this.getOvertimeDamageRounds(), newPercentage,
                1.0f);
    }

    @Override
    protected boolean hadInitialKnightModifier() {
        return true;
    }

    @Override
    protected boolean hadInitialPyromancerModifier() {
        return true;
    }

    @Override
    protected boolean hadInitialRogueModifier() {
        return true;
    }

    @Override
    protected boolean hadInitialWizardModifier() {
        return true;
    }
}
