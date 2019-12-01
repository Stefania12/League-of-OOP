package heroes.races;

import abilities.AbilityInterface;
import abilities.pyromancer.FireBlast;
import abilities.pyromancer.Ignite;
import common.Constants;
import general.Pair;
import heroes.Hero;
import heroes.HeroPriority;
import map.terrain.Desert;
import map.terrain.Land;
import map.terrain.Volcanic;
import map.terrain.Woods;

public class Pyromancer extends Hero {
    public Pyromancer(final Pair<Integer, Integer> coordinates) {
        super(HeroPriority.FIRST, Constants.PYROMANCER, coordinates,
                Constants.PYROMANCER_INITIAL_HP, Constants.PYROMANCER_HP_PER_LEVEL);
        this.getAbilities().add(new FireBlast(this));
        this.getAbilities().add(new Ignite(this));
        this.getAbilities().sort((a, b) -> {
            if (a.getPriority() != b.getPriority()) {
                return a.getPriority() - b.getPriority();
            }
            return 0;
        });
    }

    /**
     * Accept-type method that returns the value of Woods multiplier of Pyromancer.
     *
     * @param terrain Land terrain
     * @return Land multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Land terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of Volcanic multiplier of Pyromancer.
     *
     * @param terrain Volcanic terrain
     * @return Volcanic multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Volcanic terrain) {
        return Constants.PYROMANCER_BONUS_DAMAGE_MULTIPLIER;
    }

    /**
     * Accept-type method that returns the value of Desert multiplier of Pyromancer.
     *
     * @param terrain Desert terrain
     * @return Desert multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Desert terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of Woods multiplier of Pyromancer.
     * @param terrain   Woods terrain
     * @return Woods multiplier
     */
    @Override
    public float getTerrainBonusDamageMultiplier(final Woods terrain) {
        return 1.0f;
    }

    /**
     * Accept-type method that returns the value of the visit-type method of an ability.
     * @param ability   ability that hurts Pyromancer
     * @return race multiplier
     */
    @Override
    public float getRaceMultiplierOf(final AbilityInterface ability) {
        return ability.getRaceDamageMultiplier(this);
    }
}
