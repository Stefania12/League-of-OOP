package heroes;

import abilities.knight.Execute;
import abilities.knight.Slam;
import common.Constants;
import javafx.util.Pair;
import map.LandModifierFactory;

public class Knight extends Hero implements HeroInterface {
    public Knight(Pair<Integer, Integer> coordinates) {
        super(Constants.KNIGHT, coordinates);
        HP = Constants.KNIGHT_INITIAL_HP;
        maxHP = HP;
        abilities.add(new Execute(this));
        abilities.add(new Slam(this));
    }

    @Override
    public float getTerrainBonusDamageMultiplier() {
        return LandModifierFactory.getDamageBonusMultiplier(this);
    }
}
