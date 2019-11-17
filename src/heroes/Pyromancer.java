package heroes;

import abilities.pyromancer.FireBlast;
import abilities.pyromancer.Ignite;
import common.Constants;
import javafx.util.Pair;
import map.LandModifierFactory;

public class Pyromancer extends Hero implements HeroInterface {
    public Pyromancer(Pair<Integer, Integer> coordinates) {
        super(Constants.PYROMANCER, coordinates);
        HP = Constants.PYROMANCER_INITIAL_HP;
        maxHP = HP;
        abilities.add(new FireBlast(this));
        abilities.add(new Ignite(this));
    }

    @Override
    public float getTerrainBonusDamageMultiplier() {
        return LandModifierFactory.getDamageBonusMultiplier(this);
    }
}
