package abilities.rogue;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import common.Constants;
import map.Map;

/**
 * Implements Paralysis ability.
 */
public final class Paralysis extends Ability {
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
        this.initializeDamageMultipliers(Constants.PARALYSIS_KNIGHT_MULTIPLIER,
                Constants.PARALYSIS_PYROMANCER_MULTIPLIER, Constants.PARALYSIS_ROGUE_MULTIPLIER,
                Constants.PARALYSIS_WIZARD_MULTIPLIER);
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
