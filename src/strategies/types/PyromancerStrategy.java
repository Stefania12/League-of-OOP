package strategies.types;

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
    protected float getLowerDmgModifier() {
        return -Constants.PYROMANCER_STRATEGY_DMG_MULTIPLIER_LOSS;
    }

    @Override
    protected int getLowerHpChange() {
        Hero owner = getOwner();
        return (int) Math.floor(Constants.PYROMANCER_STRATEGY_HP_GAIN_PERCENTAGE * owner.getHP());
    }

    @Override
    protected float getMiddleDmgModifier() {
        return Constants.PYROMANCER_STRATEGY_DMG_MULTIPLIER_GAIN;
    }

    @Override
    protected int getMiddleHpChange() {
        Hero owner = getOwner();
        return -(int) Math.floor(Constants.PYROMANCER_STRATEGY_HP_LOSS_PERCENTAGE * owner.getHP());
    }
}
