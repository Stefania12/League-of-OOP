package heroes.races;

import abilities.AbilityInterface;
import abilities.pyromancer.FireBlast;
import abilities.pyromancer.Ignite;
import common.Constants;
import heroes.Hero;
import heroes.HeroPriority;
import javafx.util.Pair;
import map.LandModifierFactory;

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
    public float getTerrainBonusDamageMultiplier() {
        return LandModifierFactory.getInstance().getDamageBonusMultiplier(this);
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
