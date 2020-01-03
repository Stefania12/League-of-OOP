package abilities.knight;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
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
        this.initializeDamageMultipliers(Constants.SLAM_KNIGHT_MULTIPLIER,
                Constants.SLAM_PYROMANCER_MULTIPLIER, Constants.SLAM_ROGUE_MULTIPLIER,
                Constants.SLAM_WIZARD_MULTIPLIER);
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
