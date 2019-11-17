package heroes;

import abilities.wizard.Deflect;
import abilities.wizard.Drain;
import common.Constants;
import javafx.util.Pair;
import map.LandModifierFactory;

public class Wizard extends Hero implements HeroInterface {
    public Wizard(Pair<Integer, Integer> coordinates) {
        super(Constants.WIZARD, coordinates);
        HP = Constants.WIZARD_INITIAL_HP;
        maxHP = HP;
        abilities.add(new Drain(this));
        abilities.add(new Deflect(this));
    }

    @Override
    public float getTerrainBonusDamageMultiplier() {
        return LandModifierFactory.getDamageBonusMultiplier(this);
    }
}
