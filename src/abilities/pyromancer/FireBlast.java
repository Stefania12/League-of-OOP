package abilities.pyromancer;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import common.Constants;

/**
 * Implements FireBlast ability.
 */
public class FireBlast extends Ability {

    /**
     * Initialize ability.
     *
     * @param hero owner
     */
    public FireBlast(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.FIREBLAST_BASE_DAMAGE, 0,
                Constants.FIREBLAST_DAMAGE_PER_LEVEL, 0, 0, 0);
        this.setOwner(hero);
        this.initializeDamageMultipliers(Constants.FIREBLAST_KNIGHT_MULTIPLIER,
                Constants.FIREBLAST_PYROMANCER_MULTIPLIER, Constants.FIREBLAST_ROGUE_MULTIPLIER,
                Constants.FIREBLAST_WIZARD_MULTIPLIER);
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
