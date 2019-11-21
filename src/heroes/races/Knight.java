package heroes.races;

import abilities.AbilityInterface;
import abilities.knight.Execute;
import abilities.knight.Slam;
import common.Constants;
import general.Pair;
import heroes.Hero;
import heroes.HeroPriority;
import map.LandModifierFactory;

public class Knight extends Hero {
    public Knight(Pair<Integer, Integer> coordinates) {
        super(HeroPriority.FIRST, Constants.KNIGHT, coordinates, Constants.KNIGHT_INITIAL_HP);
        this.getAbilities().add(new Execute(this));
        this.getAbilities().add(new Slam(this));
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
        this.setMaxHP(Constants.KNIGHT_INITIAL_HP + Constants.KNIGHT_HP_PER_LEVEL * this.getLevel());
        this.setHP(this.getMaxHP());
    }
}
