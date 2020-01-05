package characters.heroes.races;

import abilities.Ability;
import abilities.AbilityInterface;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;
import characters.angels.Angel;
import characters.angels.AngelEffect;
import characters.angels.AngelInterface;
import characters.heroes.Hero;
import characters.heroes.HeroPriority;
import common.Constants;
import map.terrain.Desert;
import map.terrain.Land;
import map.terrain.Volcanic;
import map.terrain.Woods;
import strategies.types.WizardStrategy;
import util.Pair;

/**
 * Implements Wizard hero.
 */
public final class Wizard extends Hero {
    /**
     * Initializes Wizard hero.
     *
     * @param coordinates initial coordinates of hero
     */
    public Wizard(final Pair<Integer, Integer> coordinates) {
        super(HeroPriority.SECOND, Constants.WIZARD, coordinates,
                Constants.WIZARD_INITIAL_HP, Constants.WIZARD_HP_PER_LEVEL);
        this.getAbilities().add(new Drain(this));
        this.getAbilities().add(new Deflect(this));
        this.getAbilities().sort((a, b) -> {
            if (a.getPriority() != b.getPriority()) {
                return a.getPriority() - b.getPriority();
            }
            return 0;
        });
        setStrategy(new WizardStrategy(this));
    }

    @Override
    public String getName() {
        return "Wizard " + getId();
    }

    /**
     * Accept-type method that returns the value of Land multiplier of Wizard.
     *
     * @param terrain Land terrain
     * @return Land multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Land terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of Volcanic multiplier of Wizard.
     * @param terrain   Volcanic terrain
     * @return Volcanic multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Volcanic terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of Desert multiplier of Wizard.
     * @param terrain   Desert terrain
     * @return Desert multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Desert terrain) {
        return Constants.WIZARD_BONUS_DAMAGE_MULTIPLIER;
    }

    /**
     * Accept-type method that returns the value of Woods multiplier of Wizard.
     * @param terrain   Woods terrain
     * @return Woods multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Woods terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of the visit-type method of an ability.
     * @param ability   ability that hurts Wizard
     * @return race multiplier
     */
    @Override
    public float getRaceMultiplierOf(final AbilityInterface ability) {
        return ability.getRaceDamageMultiplier(this);
    }

    @Override
    public void receiveEffectOfAngel(final AngelInterface angel) {
        AngelEffect effect = angel.getEffectOn(this);
        if ((this.isAlive() && !effect.getRevival()) || (effect.getRevival() && !this.isAlive())) {
            angel.notifyObservers(angel, ((Angel) angel).getAction(), this);
            boolean wasAlive = isAlive();
            for (Ability a : getAbilities()) {
                a.changeRaceDamageMultipliers(effect.getDamageModifier());
            }
            this.changeHPBy(effect.getHp());
            this.updateAliveStatus();
            this.addXP(effect.getXp());
            this.notifyAngelInteraction(wasAlive, angel);
        }
    }
}
