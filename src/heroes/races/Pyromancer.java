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
    public Pyromancer(Pair<Integer, Integer> coordinates) {
        super(HeroPriority.FIRST, Constants.PYROMANCER, coordinates, Constants.PYROMANCER_INITIAL_HP);
        this.getAbilities().add(new FireBlast(this));
        this.getAbilities().add(new Ignite(this));
        this.getAbilities().sort((a, b) -> {
            if (a.getPriority() != b.getPriority()) {
                return a.getPriority() - b.getPriority();
            }
            return 0;
        });
    }

    @Override
    public float getTerrainBonusDamageMultiplier(Land terrain) {
        return 1.0f;
    }

    @Override
    public float getTerrainBonusDamageMultiplier(Volcanic terrain) {
        return Constants.PYROMANCER_BONUS_DAMAGE_MULTIPLIER;
    }

    @Override
    public float getTerrainBonusDamageMultiplier(Desert terrain) {
        return 1.0f;
    }

    @Override
    public float getTerrainBonusDamageMultiplier(Woods terrain) {
        return 1.0f;
    }

    @Override
    public float getRaceMultiplierOf(AbilityInterface ability) {
        return ability.getRaceDamageMultiplier(this);
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.setMaxHP(Constants.PYROMANCER_INITIAL_HP + Constants.PYROMANCER_HP_PER_LEVEL * this.getLevel());
        this.setHP(this.getMaxHP());
    }
}
