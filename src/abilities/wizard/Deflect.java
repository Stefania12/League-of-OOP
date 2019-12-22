package abilities.wizard;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import common.Constants;

/**
 * Implements Deflect ability.
 */
public class Deflect extends Ability {
    private static final int MAX_DMG_PERCENTAGE = Constants.DEFLECT_DAMAGE_MAX_PERCENTAGE;

    /**
     * Initialize ability.
     *
     * @param hero owner
     */
    public Deflect(final Hero hero) {
        super(AbilityPriority.SECOND.ordinal(), Constants.DEFLECT_BASE_DAMAGE_PERCENTAGE,
                0, Constants.DEFLECT_DAMAGE_PERCENTAGE_PER_LEVEL, 0, 0, 0);
        this.setOwner(hero);
        this.initializeDamageMultipliers(Constants.DEFLECT_KNIGHT_MULTIPLIER,
                Constants.DEFLECT_PYROMANCER_MULTIPLIER, Constants.DEFLECT_ROGUE_MULTIPLIER,
                Constants.DEFLECT_WIZARD_MULTIPLIER);
    }

    private float getDamagePercentage() {
        return Math.min(super.getBasicDamageOn(null), MAX_DMG_PERCENTAGE) / Constants.PERCENTAGE;
    }

    /**
     * Returns basic damage on a hero.
     *
     * @param hero hero to attack
     * @return race multiplier
     */
    @Override
    protected int getBasicDamageOn(final Hero hero) {
        int damageGot = 0;
        for (AbilityParameters i : hero.getAttacks()) {
            damageGot += Math.round(i.getBasicDamage() * i.getTerrainMultiplier());
        }
        return Math.round(damageGot * this.getDamagePercentage());
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

    @Override
    protected float getInitialKnightMultiplier() {
        return Constants.DEFLECT_KNIGHT_MULTIPLIER;
    }

    @Override
    protected float getInitialPyromancerMultiplier() {
        return Constants.DEFLECT_PYROMANCER_MULTIPLIER;
    }

    @Override
    protected float getInitialRogueMultiplier() {
        return Constants.DEFLECT_ROGUE_MULTIPLIER;
    }

    @Override
    protected float getInitialWizardMultiplier() {
        return Constants.DEFLECT_WIZARD_MULTIPLIER;
    }
}
