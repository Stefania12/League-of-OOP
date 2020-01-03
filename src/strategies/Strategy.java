package strategies;

import abilities.Ability;
import characters.heroes.Hero;

public abstract class Strategy implements StrategyInterface {
    private Hero owner;

    protected Strategy(Hero hero) {
        owner = hero;
    }

    protected Hero getOwner() {
        return owner;
    }

    @Override
    public void apply() {
        if (lowerHpCase()) {
            executeLowerHp();
        } else {
            if (middleHpCase()) {
                executeMiddleHp();
            }
        }
    }

    private boolean lowerHpCase() {
        return owner.getHP() < getLowerHpLimit();
    }

    private boolean middleHpCase() {
        return getLowerHpLimit() < owner.getHP() && owner.getHP() < getUpperHpLimit();
    }

    protected abstract float getLowerHpLimit();

    protected abstract float getUpperHpLimit();

    private void executeLowerHp() {
        for (Ability a : owner.getAbilities()) {
            a.changeRaceDamageMultipliers(getLowerDmgModifier());
        }
        owner.changeHPBy(getLowerHpChange());
    }

    private void executeMiddleHp() {
        for (Ability a : owner.getAbilities()) {
            a.changeRaceDamageMultipliers(getMiddleDmgModifier());
        }
        owner.changeHPBy(getMiddleHpChange());
    }

    protected abstract int getLowerHpChange();

    protected abstract int getMiddleHpChange();

    protected abstract float getLowerDmgModifier();

    protected abstract float getMiddleDmgModifier();
}
