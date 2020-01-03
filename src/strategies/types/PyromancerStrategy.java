package strategies.types;

import abilities.Ability;
import characters.heroes.Hero;
import common.Constants;
import strategies.Strategy;

public class PyromancerStrategy extends Strategy {
    public PyromancerStrategy(Hero hero) {
        super(hero);
    }

    @Override
    protected float getLowerHpLimit() {
        return Constants.PYROMANCER_STRATEGY_LOWER_LIMIT_COEFFICIENT * getOwner().getMaxHP();
    }

    @Override
    protected float getUpperHpLimit() {
        return Constants.PYROMANCER_STRATEGY_UPPER_LIMIT_COEFFICIENT * getOwner().getMaxHP();
    }

    @Override
    protected void executeLowerHp() {
        Hero owner = getOwner();
        for (Ability a : owner.getAbilities()) {
            a.changeRaceDamageMultipliers(-Constants.PYROMANCER_STRATEGY_DMG_MULTIPLIER_LOSS);
        }
        owner.changeHPBy((int) Math.floor(Constants.PYROMANCER_STRATEGY_HP_GAIN_PERCENTAGE * owner.getHP()));
    }

    @Override
    protected void executeMiddleHp() {
        Hero owner = getOwner();
        for (Ability a : owner.getAbilities()) {
            a.changeRaceDamageMultipliers(Constants.PYROMANCER_STRATEGY_DMG_MULTIPLIER_GAIN);
        }
        owner.changeHPBy(-(int) Math.floor(Constants.PYROMANCER_STRATEGY_HP_LOSS_PERCENTAGE * owner.getHP()));
    }
}
