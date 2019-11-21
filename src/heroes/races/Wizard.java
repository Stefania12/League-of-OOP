package heroes.races;

import abilities.AbilityInterface;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;
import common.Constants;
import heroes.Hero;
import heroes.HeroPriority;
import javafx.util.Pair;
import map.LandModifierFactory;

public class Wizard extends Hero {
    public Wizard(Pair<Integer, Integer> coordinates) {
        super(HeroPriority.SECOND, Constants.WIZARD, coordinates, Constants.WIZARD_INITIAL_HP);
        this.getAbilities().add(new Drain(this));
        this.getAbilities().add(new Deflect(this));
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
        this.setMaxHP(Constants.WIZARD_INITIAL_HP + Constants.WIZARD_HP_PER_LEVEL * this.getLevel());
        this.setHP(this.getMaxHP());
    }
}
