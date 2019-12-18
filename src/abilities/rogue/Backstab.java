package abilities.rogue;

import abilities.Ability;
import abilities.AbilityParameters;
import abilities.AbilityPriority;
import characters.heroes.Hero;
import characters.heroes.races.Knight;
import characters.heroes.races.Pyromancer;
import characters.heroes.races.Rogue;
import characters.heroes.races.Wizard;
import common.Constants;
import map.Map;

/**
 * Implements Backstab ability.
 */
public class Backstab extends Ability {
    private int counter;

    /**
     * Initialize ability.
     *
     * @param hero owner
     */
    public Backstab(final Hero hero) {
        super(AbilityPriority.FIRST.ordinal(), Constants.BACKSTAB_BASE_DAMAGE, 0,
                Constants.BACKSTAB_DAMAGE_PER_LEVEL, 0, 0, 0);
        counter = Constants.BACKSTAB_CRITICAL_HITS;
        this.setOwner(hero);
    }

    private void decreaseCounter() {
        if (counter - 1 == 0) {
            counter = Constants.BACKSTAB_CRITICAL_HITS;
        } else {
            counter--;
        }
    }

    private float getCriticalValue() {
        char terrain = Map.getInstance().getTerrainAt(this.getOwner().getCoordinates()).getType();
        if (terrain == Constants.WOODS && counter == Constants.BACKSTAB_CRITICAL_HITS) {
            return Constants.BACKSTAB_CRITICAL_PERCENTAGE;
        }
        return 1.0f;
    }

    /**
     * Returns basic damane on hero.
     *
     * @param hero hero to attack
     * @return basic damage
     */
    @Override
    protected int getBasicDamageOn(final Hero hero) {
        return Math.round(super.getBasicDamageOn(hero) * this.getCriticalValue());
    }

    /**
     * Returns race multiplier for Rogue opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Rogue hero) {
        return Constants.BACKSTAB_ROGUE_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Knight opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Knight hero) {
        return Constants.BACKSTAB_KNIGHT_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Wizard opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Wizard hero) {
        return Constants.BACKSTAB_WIZARD_MULTIPLIER;
    }

    /**
     * Returns race multiplier for Pyromaner opponent.
     * @param hero  hero
     * @return race multiplier
     */
    @Override
    public float getRaceDamageMultiplier(final Pyromancer hero) {
        return Constants.BACKSTAB_PYROMANCER_MULTIPLIER;
    }

    /**
     * Calculates ability parameters when attacking a hero.
     * @param hero  hero to attack
     * @return parameters of ability
     */
    @Override
    public AbilityParameters getAbilityParametersOn(final Hero hero) {
        AbilityParameters ability = new AbilityParameters(this.getPriority(),
                this.getBasicDamageOn(hero), this.getIncapacitationRounds(),
                this.getTotalOvertimeDamage(), this.getOvertimeDamageRounds(),
                this.getTerrainMultiplier(), hero.getRaceMultiplierOf(this));
        this.decreaseCounter();
        return ability;
    }
}
