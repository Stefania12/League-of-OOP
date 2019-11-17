package heroes;

import abilities.rogue.Backstab;
import abilities.rogue.Paralysis;
import common.Constants;
import javafx.util.Pair;
import map.LandModifierFactory;

public class Rogue extends Hero implements HeroInterface {
    public Rogue(Pair<Integer, Integer> coordinates) {
        super(Constants.ROGUE, coordinates);
        HP = Constants.ROGUE_INITIAL_HP;
        maxHP = HP;
        abilities.add(new Backstab(this));
        abilities.add(new Paralysis(this));
    }

    @Override
    public float getTerrainBonusDamageMultiplier() {
        return LandModifierFactory.getDamageBonusMultiplier(this);
    }

}
