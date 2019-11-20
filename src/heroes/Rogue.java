package heroes;

import abilities.AbilityInterface;
import abilities.rogue.Backstab;
import abilities.rogue.Paralysis;
import common.Constants;
import javafx.util.Pair;
import map.LandModifierFactory;

public class Rogue extends Hero {
    public Rogue(Pair<Integer, Integer> coordinates) {
        super(Constants.ROGUE, coordinates, Constants.ROGUE_INITIAL_HP);
        this.getAbilities().add(new Backstab(this));
        this.getAbilities().add(new Paralysis(this));
        this.getAbilities().sort((a, b) -> {
            if (a.getPriority() != b.getPriority()) {
                return a.getPriority() - b.getPriority();
            }
            return 0;
        });
    }

    @Override
    public float getTerrainBonusDamageMultiplier() {
        return LandModifierFactory.getInstance().getDamageBonusMultiplier(this);
    }

    @Override
    public void attack(Hero hero) {

    }

    @Override
    public float getRaceMultiplierOf(AbilityInterface ability) {
        return ability.getRaceDamageMultiplier(this);
    }

}
