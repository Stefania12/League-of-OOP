package heroes.races;

import abilities.AbilityInterface;
import abilities.wizard.Deflect;
import abilities.wizard.Drain;
import common.Constants;
import general.Pair;
import heroes.Hero;
import heroes.HeroPriority;
import map.terrain.Desert;
import map.terrain.Land;
import map.terrain.Volcanic;
import map.terrain.Woods;

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
    public float getTerrainBonusDamageMultiplier(Land terrain) {
        return 1.0f;
    }

    @Override
    public float getTerrainBonusDamageMultiplier(Volcanic terrain) {
        return 1.0f;
    }

    @Override
    public float getTerrainBonusDamageMultiplier(Desert terrain) {
        return Constants.WIZARD_BONUS_DAMAGE_MULTIPLIER;
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
        this.setMaxHP(Constants.WIZARD_INITIAL_HP + Constants.WIZARD_HP_PER_LEVEL * this.getLevel());
        this.setHP(this.getMaxHP());
    }
}
