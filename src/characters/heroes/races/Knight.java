package characters.heroes.races;

import abilities.Ability;
import abilities.AbilityInterface;
import abilities.knight.Execute;
import abilities.knight.Slam;
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
import strategies.types.KnightStrategy;
import util.Pair;

/**
 * Implements Knight hero.
 */
public class Knight extends Hero {
    public Knight(final Pair<Integer, Integer> coordinates) {
        super(HeroPriority.FIRST, Constants.KNIGHT, coordinates,
                Constants.KNIGHT_INITIAL_HP, Constants.KNIGHT_HP_PER_LEVEL);
        this.getAbilities().add(new Execute(this));
        this.getAbilities().add(new Slam(this));
        this.getAbilities().sort((a, b) -> {
            if (a.getPriority() != b.getPriority()) {
                return a.getPriority() - b.getPriority();
            }
            return 0;
        });
        setStrategy(new KnightStrategy(this));
    }

    @Override
    public String getName() {
        return "Knight " + getId();
    }

    /**
     * Accept-type method that returns the value of Land multiplier of Knight.
     *
     * @param terrain Land terrain
     * @return Land multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Land terrain) {
        return Constants.KNIGHT_BONUS_DAMAGE_MULTIPLIER;
    }

    /**
     * Accept-type method that returns the value of Volcanic multiplier of Knight.
     *
     * @param terrain Volcanic terrain
     * @return Volcanic multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Volcanic terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of Desert multiplier of Knight.
     *
     * @param terrain Desert terrain
     * @return Desert multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Desert terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of Woods multiplier of Knight.
     * @param terrain   Woods terrain
     * @return Woods multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Woods terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of the visit-type method of an ability.
     * @param ability   ability that hurts Knight
     * @return race multiplier
     */
    @Override
    public float getRaceMultiplierOf(final AbilityInterface ability) {
        return ability.getRaceDamageMultiplier(this);
    }

    @Override
    public void receiveEffectOfAngel(AngelInterface angel) {
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
