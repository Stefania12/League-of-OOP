package abilities.pyromancer;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import common.Constants;

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
        this.initializeDamageMultipliers(Constants.IGNITE_KNIGHT_MULTIPLIER,
                Constants.IGNITE_PYROMANCER_MULTIPLIER, Constants.IGNITE_ROGUE_MULTIPLIER,
                Constants.IGNITE_WIZARD_MULTIPLIER);
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
